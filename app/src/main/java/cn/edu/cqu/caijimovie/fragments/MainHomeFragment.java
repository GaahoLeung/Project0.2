package cn.edu.cqu.caijimovie.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.edu.cqu.caijimovie.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainHomeFragment extends MyFragment {
    private SearchView mSearchView;

    public MainHomeFragment() {
        super("Home");
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main_home, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mSearchView = (SearchView) getActivity().findViewById(R.id.search_movie);
        mSearchView.setIconifiedByDefault(false);
        mSearchView.setSubmitButtonEnabled(true);

    }
//    @Override
//    public void setUserVisibleHint(boolean isVisibleToUser) {
//        super.setUserVisibleHint(isVisibleToUser);
//        if (isVisibleToUser) {
//            //相当于Fragment的onResume
//        } else {
//            //相当于Fragment的onPause
//            mSearchView.clearFocus();
//        }
//    }


}
