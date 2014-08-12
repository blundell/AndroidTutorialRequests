package com.blundell.request.signupform.signup;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.blundell.request.signupform.R;
import com.blundell.request.signupform.main.MainActivity;

public class SignUpFormActivity extends Activity implements SignUpFormFragment.Listener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_form);
    }

    @Override
    public void onSignUpInformationSaved() {
        gotoMainActivity();
        finish();
    }

    private void gotoMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
