package com.jayseeofficial.playingwithdesign;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by jon on 29/05/15.
 */
public class TextInputLayoutFragment extends Fragment {

    @InjectView(R.id.layout_text_input)
    TextInputLayout layoutTextInput;

    @InjectView(R.id.btn_ok)
    Button btnOk;

    public static TextInputLayoutFragment getInstance() {
        TextInputLayoutFragment fragment = new TextInputLayoutFragment();

        return fragment;
    }

    public TextInputLayoutFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View mainView = inflater.inflate(R.layout.fragment_text_input_layout, container, false);
        ButterKnife.inject(this, mainView);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processText();
            }
        });

        return mainView;
    }

    private void processText() {
        if (layoutTextInput.getEditText().getText().toString().equalsIgnoreCase("hello world!")) {
            layoutTextInput.setErrorEnabled(false);
            Toast.makeText(getActivity(), "Hellooooooo!", Toast.LENGTH_SHORT).show();
        } else {
            layoutTextInput.setError("Wrong input!");
            layoutTextInput.setErrorEnabled(true);
        }
    }
}
