package com.blundell.request.signupform;

import android.content.Context;
import android.content.SharedPreferences;

public class AppSharedPreferences {

    private static final String PREFERENCES_NAME = "AppSharedPreferences";
    private static final String KEY_SIGN_UP_NAME = "AppSharedPreferences.SIGN_UP_NAME";

    private final SharedPreferences sharedPreferences;

    public static AppSharedPreferences newInstance(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
        return new AppSharedPreferences(sharedPreferences);
    }

    AppSharedPreferences(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
    }

    public void saveSignUpName(String signUpInfo) {
        sharedPreferences.edit().putString(KEY_SIGN_UP_NAME, signUpInfo).apply();
    }

    public boolean hasSignUpInformation() {
        return getSignUpName() != null;
    }

    public String getSignUpName() {
        return sharedPreferences.getString(KEY_SIGN_UP_NAME, null);
    }

    public void clearSignUpInformation() {
        sharedPreferences.edit().remove(KEY_SIGN_UP_NAME).apply();
    }
}
