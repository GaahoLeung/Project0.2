package cn.edu.cqu.caijimovie.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import cn.edu.cqu.caijimovie.R;
import cn.edu.cqu.caijimovie.entities.Movie;


public class MainRecommendFragment extends MyFragment {

    private ArrayList<Movie> RecommendList = new ArrayList<>();
    private RecyclerView recyclerView;

    public MainRecommendFragment() {
        super("Recommend");
        // Required empty public constructor
    }

    //
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //实例化recyclerView
        recyclerView = getActivity().findViewById(R.id.main_recommend_recycler);

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main_recommend, container, false);
    }


}
