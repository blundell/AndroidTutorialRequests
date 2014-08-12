package com.blundell.request.signupform.main;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.blundell.request.signupform.AppSharedPreferences;
import com.blundell.request.signupform.R;

public class MainFragment extends Fragment {

    private AppSharedPreferences preferences;
    private TextView welcomeTextView;
    private View clearButton;
    private Listener listener;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        listener = (Listener) activity;
        preferences = AppSharedPreferences.newInstance(activity);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        welcomeTextView = (TextView) rootView.findViewById(R.id.main_text_welcome);
        clearButton = rootView.findViewById(R.id.main_button_clear);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String welcomeText = getString(R.string.main_text_welcome, preferences.getSignUpName());
        welcomeTextView.setText(welcomeText);

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                preferences.clearSignUpInformation();
                listener.onSignUpClearClick();
            }
        });
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    interface Listener {
        void onSignUpClearClick();
    }
}
