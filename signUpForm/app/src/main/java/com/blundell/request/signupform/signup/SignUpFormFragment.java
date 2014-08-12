package com.blundell.request.signupform.signup;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.blundell.request.signupform.AppSharedPreferences;
import com.blundell.request.signupform.R;

public class SignUpFormFragment extends Fragment {

    private AppSharedPreferences preferences;
    private EditText nameEditText;
    private View saveButton;
    private Listener listener;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        listener = (Listener) activity;
        preferences = AppSharedPreferences.newInstance(activity);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_sign_up_form, container, false);

        nameEditText = (EditText) rootView.findViewById(R.id.sign_up_name_edit_text);
        saveButton = rootView.findViewById(R.id.sign_up_save_button);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveSignUpInformation();
                listener.onSignUpInformationSaved();
            }
        });
    }

    private void saveSignUpInformation() {
        String nameInput = nameEditText.getText().toString();
        preferences.saveSignUpName(nameInput);
    }

    interface Listener {
        void onSignUpInformationSaved();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}
