package cn.edu.cqu.caijimovie.fragments;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import cn.edu.cqu.caijimovie.R;
import cn.edu.cqu.caijimovie.activities.MainActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class SignUpFragment extends MyFragment {

    Context mContext;
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


                        Toast.makeText(mContext, "注册成功", Toast.LENGTH_SHORT).show();
                    }
                });
                break;
        }

    }

}
