package com.myexamples.tokengenerator;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class Proxy extends AppCompatActivity {

    // Request code(s) used to start new activity for result
    public final static int GET_RESULT_REQCODE = 1;
    public final static String TOKENS_TAG = "com.myexamples.tokengenerator.TOKENS_TAG";
    public final static Integer NUMBER_OF_TOKENS = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
        setContentView(R.layout.activity_proxy);

        TextView WelcomeText = (TextView) findViewById(R.id.textView3);
        String fullWelcome = getFullWelcome();
        WelcomeText.setText(fullWelcome);
    }

    // Add name and surname to welcome text
    private String getFullWelcome()
    {
        Intent intent = getIntent();
        TextView WelcomeText = (TextView) findViewById(R.id.textView3);
        int pos = WelcomeText.getText().toString().indexOf(',');
        String name = intent.getStringExtra(MainActivity.NAME_TAG);
        String surname = intent.getStringExtra(MainActivity.SURNAME_TAG);
        String fullName = ' ' + name + "\n" + surname;
        return new StringBuilder(WelcomeText.getText().toString()).insert(pos+1, fullName).toString();
    }

    // Random integer number generator (range: 1-max)
    private int generateToken()
    {
        int tokenNumber = 1000000;
        Random gen = new Random();
        return gen.nextInt(tokenNumber);
    }

    public void goToActivationScreen(View view)
    {
        Intent intent = new Intent(this, Authenticator.class);
        startActivityForResult(intent, GET_RESULT_REQCODE);
    }

    /**
     * Method that will process result received from Authenticator
     */
    @SuppressLint("DefaultLocale")
    @Override
    protected void onActivityResult(int reqCode, int resultCode, Intent data)
    {
        TextView textVeiw = (TextView) findViewById(R.id.textView4);
        Button button = (Button) findViewById(R.id.button2);

        if(reqCode != GET_RESULT_REQCODE )
            return;
        if (resultCode == RESULT_OK) {
            textVeiw.setText(R.string.been_authenticated);
            final Intent intent = new Intent(this, Tokens.class);
            button.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v){
                    ArrayList<String> tokens = new ArrayList<>();
                    for(int i = 0; i < NUMBER_OF_TOKENS; i++)
                    {
                        tokens.add(Integer.toString(generateToken()));
                    }
                    intent.putStringArrayListExtra(TOKENS_TAG, tokens);
                    startActivity(intent);
                }
            });
        }
        else if (resultCode == RESULT_CANCELED) {
            textVeiw.setText(R.string.auth_failed);
            final Intent intent = new Intent(this, MainActivity.class);
            button.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v){
                    startActivity(intent);
                }
            });
        }
    }
}