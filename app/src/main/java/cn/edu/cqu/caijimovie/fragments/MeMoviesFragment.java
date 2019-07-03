package cn.edu.cqu.caijimovie.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.edu.cqu.caijimovie.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MeMoviesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MeMoviesFragment extends Fragment {

    public MeMoviesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_me_movies, container, false);
    }

}
