package com.example.mickalcinier.diabete;

/**
 * Created by Mickaël CINIER on 10/09/2016.
 */
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;


public class AccessTokenReceiver extends AppCompatActivity {

    String string;


    @Override
    protected void onNewIntent(Intent intent) {
        string = intent.getDataString();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onNewIntent(getIntent());
        String code = string.substring(string.indexOf("code") + 5, string.indexOf("#_=_"));
        //String userId = string.substring(string.indexOf("&user_id")+9, string.indexOf("&token_type"));
        //String tokenType = string.substring(string.indexOf("&token_type")+12,string.indexOf("&expires_in"));
        //String refreshToken = string.substring(string.indexOf("&refresh_token")+12,string.indexOf("&expires_in"));

        Log.i("TAG", string);
        Log.i("TAG CODE : ", code);
        //Log.i("TAG", userId);
        //Log.i("TAG", tokenType);

        SharedPreferences sharedPreferences =
                PreferenceManager.getDefaultSharedPreferences(this);
        //sharedPreferences.edit().putBoolean(QuickPreferences.HAVE_AUTHORIZATION, true).apply();
        //sharedPreferences.edit().putString(QuickPreferences.ACCESS_TOKEN, code).apply();
        //sharedPreferences.edit().putString(QuickPreferences.USER_ID,userId).apply();
        //sharedPreferences.edit().putString(QuickPreferences.TOKEN_TYPE,tokenType).apply();
        //sharedPreferences.edit().putString(QuickPreferences.FULL_AUTHORIZATION,tokenType+" "+accessToken).apply();

        Intent intent = new Intent(AccessTokenReceiver.this, MainActivity.class);
        startActivity(intent);
    }
}