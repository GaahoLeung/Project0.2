package cn.edu.cqu.caijimovie.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import cn.edu.cqu.caijimovie.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainRecommendFragment extends MyFragment {

    private List<ItemMovieFragment> RecommendList = new ArrayList<>();

    public MainRecommendFragment() {
        super("Recommend");
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main_recommend, container, false);
    }


}
