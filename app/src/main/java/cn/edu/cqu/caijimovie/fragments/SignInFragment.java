package cn.edu.cqu.caijimovie.fragments;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.net.wifi.hotspot2.pps.HomeSp;
import android.os.Bundle;
import android.os.Looper;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import cn.edu.cqu.caijimovie.R;
import cn.edu.cqu.caijimovie.activities.MainActivity;
import cn.edu.cqu.caijimovie.activities.SignUpInActivity;
import cn.edu.cqu.caijimovie.activities.SplashActivity;
import cn.edu.cqu.caijimovie.entities.Result;
import cn.edu.cqu.caijimovie.entities.User;
import cn.edu.cqu.caijimovie.utils.CheckInfoUtils;
import cn.edu.cqu.caijimovie.utils.HttpUtils;
import cn.edu.cqu.caijimovie.utils.UrlUtils;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class SignInFragment extends MyFragment implements View.OnClickListener {

    Context mContext;
    private String requrl;
    private EditText usermail;
    private EditText userpassword;
    private String usermailstr, userpasswordstr;
    private User user = new User();
    private int logstatus = -1;



    public SignInFragment() {
        // Required empty public constructor
        super("Sign In");
    }
    public void onCreate(Bundle savedInstanceState){
        //获取上下文
        super.onCreate(savedInstanceState);
        mContext=getActivity();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //创建布局视图
        return inflater.inflate(R.layout.fragment_sign_in, container, false);
    }
    @Override
    public void onClick(View v) {
    }

    //Todo:绑定按钮事件？
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        usermail = (EditText) getActivity().findViewById(R.id.txtEmali);
        userpassword = (EditText) getActivity().findViewById(R.id.txtPsw);
        Button btnSignIn = (Button) getActivity().findViewById(R.id.btnLogin);
        btnClicked(btnSignIn);//初始化按钮事件
    }


    public void btnClicked(View v) {
        switch (v.getId()) {
            case R.id.btnLogin:
                v.setOnClickListener(new View.OnClickListener() {
                    @Override
                    //Todo:此处编写登录按钮要处理的事务，要获取Email和Password，本地进行邮箱验证、密码验证，验证完成后提交服务器进行二次验证。
                    //Todo:返回认证信息，并用Toast告诉用户简单易懂的错误信息。     注意！！要开启线程来进行服务器验证，以免卡死。
                    public void onClick(View v) {
                        usermailstr = usermail.getText().toString().trim();
                        userpasswordstr = userpassword.getText().toString().trim();

                        //Todo:快速调试用
                        Intent intent = new Intent(getActivity().getApplicationContext(), MainActivity.class);
                        intent.putExtra("currentuser", user);
                        startActivity(intent);
                        getActivity().finish();

                        if (usermailstr == null || usermailstr.equals("") || userpasswordstr == null || userpasswordstr.equals("")) {
                            Toast.makeText(getActivity(), "用户名或密码为空！", Toast.LENGTH_SHORT).show();
                        } else if (!CheckInfoUtils.isEmail(usermailstr)) {
                            Toast.makeText(getActivity(), "邮箱格式错误！", Toast.LENGTH_SHORT).show();
                        } else {

//                            requrl = "http://192.168.43.94:8080/api/user?mail="+usermailstr+"&password="+userpasswordstr;
//                            Log.e("json", requrl);
                            Log.e("01", UrlUtils.Signin(usermailstr, userpasswordstr));
                            HttpUtils.sendOkHttpRequest(UrlUtils.Signin(usermailstr, userpasswordstr), new Callback() {

                                @Override
                                public void onFailure(Call call, IOException e) {

                                }

                                @Override
                                public void onResponse(Call call, Response response) throws IOException {

                                    final String responseString = response.body().string();

                                    new Thread(new Runnable() {
                                        @Override
                                        public void run() {
                                            //JSONObject jsonobject = new JSONObject(responseString);
                                            //将json数据与实体类相关联
                                            Result result = new Gson().fromJson(responseString, Result.class);

                                            logstatus = result.getReturnValue();
                                            Log.i("json", "json对象: " + logstatus);
                                            switch (logstatus) {
                                                case 0:
                                                    //user = new Gson().fromJson(result.getObject(),User.class);
                                                    user = new Gson().fromJson(result.getObject(), User.class);
                                                    Log.i("用户信息", "邮箱" + user.getMail() + "用户id" + user.getUid());
//                                                    SystemClock.sleep(2000);
                                                    //System.out.println(user.getMail());
                                                    Intent intent = new Intent(getActivity().getApplicationContext(), MainActivity.class);
                                                    intent.putExtra("currentuser", user);
                                                    startActivity(intent);
                                                    getActivity().finish();
                                                    break;
                                                case 1:
                                                    Log.i("登录状态", "json对象: " + logstatus);
                                                    Looper.prepare();
                                                    Toast.makeText(getActivity(), "账号不存在", Toast.LENGTH_SHORT).show();
                                                    Looper.loop();
                                                    break;
                                                case 2:
                                                    Log.i("登录状态", "json对象: " + logstatus);
                                                    Looper.prepare();
                                                    Toast.makeText(getActivity(), "密码错误", Toast.LENGTH_SHORT).show();
                                                    Looper.loop();
                                                    break;
                                                case -1:
                                                    Looper.prepare();
                                                    Toast.makeText(getActivity(), "网络错误", Toast.LENGTH_SHORT).show();
                                                    Looper.loop();
                                                    break;

                                            }
                                        }
                                    }).start();

                                }
                            });

                        }

                    }
                });
                break;
        }

    }

}
