package cn.edu.cqu.caijimovie.fragments;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.IOException;

import cn.edu.cqu.caijimovie.R;
import cn.edu.cqu.caijimovie.activities.MainActivity;
import cn.edu.cqu.caijimovie.entities.Result;
import cn.edu.cqu.caijimovie.entities.User;
import cn.edu.cqu.caijimovie.utils.CheckInfoUtils;
import cn.edu.cqu.caijimovie.utils.HttpUtils;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class SignUpFragment extends MyFragment {

    Context mContext;
    private EditText mail, password1, password2;
    private String mailstr, password1str, password2str;
    private int regstatus = -1;
    private User user;

    public SignUpFragment() {
        super("Sign Up");  // Required empty public constructor
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);     //获取上下文
        mContext = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //创建布局视图
        return inflater.inflate(R.layout.fragment_sign_up, container, false);
    }

    //Todo:绑定按钮事件
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mail = (EditText) getActivity().findViewById(R.id.txtRegEmali);
        password1 = (EditText) getActivity().findViewById(R.id.txtRegPsw);
        password2 = (EditText) getActivity().findViewById(R.id.txtRegPswConfirm);
        Button btnSignUp = (Button) getActivity().findViewById(R.id.btnSignUp);
        btnClicked(btnSignUp);//初始化按钮事件
    }

    public void btnClicked(View v) {
        switch (v.getId()) {
            case R.id.btnSignUp:
                v.setOnClickListener(new View.OnClickListener() {
                    @Override
                    //Todo:此处编写注册按钮要处理的事务，要获取Email和Password，本地进行邮箱验证、密码、确认密码验证，验证完成后提交服务器进行二次验证。返回认证信息
                    //Todo:并用Toast告诉用户简单易懂的错误信息。  注意！！要开启线程来进行服务器验证，以免卡死。
                    public void onClick(View v) {
                        mailstr = mail.getText().toString().trim();
                        password1str = password1.getText().toString().trim();
                        password2str = password2.getText().toString().trim();
                        if (mailstr == null || mailstr.equals("") || password1str == null || password1str.equals("") || password2str == null || password2str.equals("")) {
                            Toast.makeText(mContext, "邮箱或密码为空！", Toast.LENGTH_SHORT).show();
                        } else if (!password1str.equals(password2str)) {
                            Toast.makeText(mContext, "两次输入的密码不同！", Toast.LENGTH_SHORT).show();
                        } else if (!CheckInfoUtils.isEmail(mailstr)) {
                            Toast.makeText(getActivity(), "邮箱格式错误！", Toast.LENGTH_SHORT).show();
                        } else {

                            RequestBody formBody = new FormBody.Builder()
                                    .add("mail", mailstr)
                                    .add("password", password1str)
                                    .build();


                            HttpUtils.sendOkHttpRequest("http://192.168.43.94:8090/api/user", formBody, new Callback() {
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

                                            regstatus = result.getReturnValue();
                                            Log.i("json", "json对象: " + regstatus);
                                            switch (regstatus) {
                                                case 4:
                                                    //user = new Gson().fromJson(result.getObject(),User.class);
                                                    user = new Gson().fromJson(result.getObject(), User.class);
                                                    Log.i("用户信息", "邮箱" + user.getMail() + "用户id" + user.getUid());
                                                    Looper.prepare();
                                                    Toast.makeText(getActivity(), "注册成功", Toast.LENGTH_SHORT).show();
                                                    Looper.loop();
//                                                    SystemClock.sleep(2000);
                                                    //System.out.println(user.getMail());
//                                                    Intent intent = new Intent(getActivity().getApplicationContext(), MainActivity.class);
//                                                    intent.putExtra("currentuser",user);
//                                                    startActivity(intent);
//                                                    getActivity().finish();
                                                    break;
                                                case 3:
                                                    Log.i("登录状态", "json对象: " + regstatus);
                                                    Looper.prepare();
                                                    Toast.makeText(getActivity(), "邮箱已存在", Toast.LENGTH_SHORT).show();
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


//                        Toast.makeText(mContext, "注册成功", Toast.LENGTH_SHORT).show();
//                        Intent intent = new Intent(getActivity().getApplicationContext(), MainActivity.class);
//                        startActivity(intent);
//                        getActivity().finish();
                    }
                });
                break;
        }

    }

}
