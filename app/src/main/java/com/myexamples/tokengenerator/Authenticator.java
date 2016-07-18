package com.myexamples.tokengenerator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Authenticator extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
        setContentView(R.layout.activity_authenticator);
    }
}
