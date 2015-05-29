package com.jayseeofficial.playingwithdesign;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by jon on 29/05/15.
 */
public class SnackbarFragment extends Fragment {

    @InjectView(R.id.btn_show_snack_bar)
    Button btnShowSnackBar;

    public static SnackbarFragment getInstance() {
        SnackbarFragment fragment = new SnackbarFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View mainView = inflater.inflate(R.layout.fragment_snackbar, container, false);
        ButterKnife.inject(this, mainView);

        btnShowSnackBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(mainView, "I am a snackbar!", Snackbar.LENGTH_LONG)
                        .setAction("Click me!", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Snackbar.make(mainView, "Snackbar clicked!", Snackbar.LENGTH_LONG).show();
                            }
                        }).show();
            }
        });

        return mainView;
    }

    public SnackbarFragment() {
    }

}
