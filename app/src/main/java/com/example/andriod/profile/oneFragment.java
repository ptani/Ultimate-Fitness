package com.example.andriod.profile;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


public class oneFragment extends Fragment {


    public static oneFragment newInstance() {
        oneFragment fragment = new oneFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View rootview = inflater.inflate(R.layout.fragment_one, container, false);
        final CollapsingToolbarLayout collapsingToolbarLayout =
                (CollapsingToolbarLayout) rootview.findViewById(R.id.collapsing_toolbar);
        collapsingToolbarLayout.setTitle(" Hi! Imran ");


        return rootview;
    }

}
