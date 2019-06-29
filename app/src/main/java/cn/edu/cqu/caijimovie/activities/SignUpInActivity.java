package cn.edu.cqu.caijimovie.activities;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

import cn.edu.cqu.caijimovie.R;
import cn.edu.cqu.caijimovie.adapter.ViewPagerWithTabAdapter;
import cn.edu.cqu.caijimovie.fragments.MyFragment;
import cn.edu.cqu.caijimovie.fragments.SignInFragment;
import cn.edu.cqu.caijimovie.fragments.SignUpFragment;

public class SignUpInActivity extends AppCompatActivity {

    ViewPager viewPager;

    ArrayList<MyFragment> fragments;

    ViewPagerWithTabAdapter adapter;

    TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_in);


        iniFragData();
    }


    //Todo:初始化两个Fragments的界面
    private void iniFragData() {
        viewPager=findViewById(R.id.viewPagerSign);
        //初始化两个fragment
        fragments=new ArrayList<>();
        fragments.add(new SignInFragment());
        fragments.add(new SignUpFragment());

        //设置ViewPager的适配器
        adapter = new ViewPagerWithTabAdapter(getSupportFragmentManager(), fragments);
        viewPager.setAdapter(adapter);


        //设置TabLayout样式
        tabLayout = findViewById(R.id.signTabLayout);
        tabLayout.setupWithViewPager(viewPager, true);
        tabLayout.setUnboundedRipple(true);
    }
}
