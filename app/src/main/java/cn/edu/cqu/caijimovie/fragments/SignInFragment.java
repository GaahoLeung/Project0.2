package cn.edu.cqu.caijimovie.fragments;


import android.content.Intent;
import android.net.wifi.hotspot2.pps.HomeSp;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Switch;

import cn.edu.cqu.caijimovie.R;
import cn.edu.cqu.caijimovie.activities.MainActivity;
import cn.edu.cqu.caijimovie.activities.SignUpInActivity;
import cn.edu.cqu.caijimovie.activities.SplashActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class SignInFragment extends Fragment implements View.OnClickListener {

    private Button btnLogin;
    private Button btnSwitchToRegister;

    public SignInFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sign_in, container, false);
    }


    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnLogin:{
                //Todo:验证登录
                Intent intent= new Intent(getActivity().getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
            case R.id.btnSwitch2Register:{
                //Todo:销毁Fragment

            }
        }



    }
}
