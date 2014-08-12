package com.blundell.request.signupform.main;

import android.app.Activity;
import android.os.Bundle;

import com.blundell.request.signupform.R;

public class MainActivity extends Activity implements MainFragment.Listener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onSignUpClearClick() {
        finish();
    }
}
