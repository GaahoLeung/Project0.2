package cn.edu.cqu.caijimovie.fragments;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.net.wifi.hotspot2.pps.HomeSp;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

import cn.edu.cqu.caijimovie.R;
import cn.edu.cqu.caijimovie.activities.MainActivity;
import cn.edu.cqu.caijimovie.activities.SignUpInActivity;
import cn.edu.cqu.caijimovie.activities.SplashActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class SignInFragment extends MyFragment implements View.OnClickListener {

    Context mContext;
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
                        Intent intent = new Intent(getActivity().getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                        getActivity().finish();
                    }
                });
                break;
        }

    }

}
