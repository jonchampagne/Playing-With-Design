package com.jayseeofficial.playingwithdesign;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by jon on 29/05/15.
 */
public class FloatingActionButtonFragment extends Fragment {

    @InjectView(R.id.floating_action_button)
    FloatingActionButton fab;

    @InjectView(R.id.tb_main)
    Toolbar tbMain;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Activity activity = getActivity();
        if (activity instanceof AppCompatActivity) {
            ((AppCompatActivity) activity).setSupportActionBar(tbMain);
        }
    }

    public static FloatingActionButtonFragment getInstance() {
        FloatingActionButtonFragment fragment = new FloatingActionButtonFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View mainView = inflater.inflate(R.layout.fragment_floating_action_button, container, false);
        ButterKnife.inject(this, mainView);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Button pressed!", Toast.LENGTH_SHORT).show();
            }
        });
        return mainView;
    }

    public FloatingActionButtonFragment() {
    }

}
