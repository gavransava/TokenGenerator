package com.myexamples.tokengenerator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        handleEditTextFocus();
    }

    private void handleEditTextFocus()
    {
        final EditText et = (EditText) findViewById(R.id.editText);
        et.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    if (et.getText().toString().isEmpty())
                        et.setText(R.string.enter_name);
                } else {
                    et.setText("");
                }
            }
        });
        final EditText et2 = (EditText) findViewById(R.id.editText2);
        et2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    if (et2.getText().toString().isEmpty())
                        et2.setText(R.string.enter_surname);
                } else {
                    et2.setText("");
                }
            }
        });
    }

}
