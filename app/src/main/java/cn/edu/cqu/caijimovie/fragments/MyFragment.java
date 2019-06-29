package cn.edu.cqu.caijimovie.fragments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toolbar;

import cn.edu.cqu.caijimovie.R;

@SuppressLint("ValidFragment")
public class MyFragment extends Fragment {

    private final String title;

    Context mContext;


    @SuppressLint("ValidFragment")
    public MyFragment(String title) {
        super();
        this.title = title;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();

    }


    public String getTitle() {
        return title;
    }
}
