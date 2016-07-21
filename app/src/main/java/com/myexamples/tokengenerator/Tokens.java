package com.myexamples.tokengenerator;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class Tokens extends AppCompatActivity {


    public final static int VALID_TOKEN = 6;
    ArrayList<String> listTokens = null;
    ListView mListViewTokens = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB)
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
        setContentView(R.layout.activity_tokens);

        Bundle extras = getIntent().getExtras();
        listTokens = extras.getStringArrayList(Proxy.TOKENS_TAG);
        insertZeros(listTokens);

        ArrayAdapter<String> tokensAdapter =
                new ArrayAdapter<>(this, R.layout.row, listTokens);
        tokensAdapter.setNotifyOnChange(true);

        mListViewTokens = (ListView) findViewById(R.id.listView);
        mListViewTokens.setAdapter(tokensAdapter);
    }

    // Add leading zeros if token number has less than 6 digits.
    private void insertZeros(ArrayList<String> listTokens)
    {
        for(int i=0; i < listTokens.size(); i++)
        {
            if (listTokens.get(i).length() < VALID_TOKEN)
            {
                int numOfZeros = VALID_TOKEN - listTokens.get(i).length();
                StringBuilder sb = new StringBuilder(listTokens.get(i));
                for(int j=0; j<numOfZeros;j++) sb.insert(0,'0');
                listTokens.set(i, sb.toString());
            }
        }
    }
}
