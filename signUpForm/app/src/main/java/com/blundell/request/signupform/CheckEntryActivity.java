package com.blundell.request.signupform;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.blundell.request.signupform.main.MainActivity;
import com.blundell.request.signupform.signup.SignUpFormActivity;

public class CheckEntryActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_entry);
        AppSharedPreferences preferences = AppSharedPreferences.newInstance(this);
        if (preferences.hasSignUpInformation()) {
            gotoMainActivity();
        } else {
            gotoSignUpActivity();
        }
        finish();
    }

    private void gotoMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void gotoSignUpActivity() {
        Intent intent = new Intent(this, SignUpFormActivity.class);
        startActivity(intent);
    }
}
