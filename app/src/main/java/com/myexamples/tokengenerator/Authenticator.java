package com.myexamples.tokengenerator;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Authenticator extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB)
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
        setContentView(R.layout.activity_authenticator);
    }

    public void onFinish(View view)
    {
        if(view.getId() == R.id.button3)
            setResult(Activity.RESULT_OK);
        else if(view.getId() == R.id.button4)
            setResult(Activity.RESULT_CANCELED);

        finish();
    }
}
