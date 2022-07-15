package com.example.adapp;


import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;

import android.view.View;

import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.text);

        Button startButton = (Button) findViewById(R.id.jsonbutton);
        startButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startjsonfile();
            }
        });

        Button startjh = (Button) findViewById(R.id.jsonhttpbutton);
        startjh.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startjsonhttpfile();
            }
        });

        Button starttf = (Button) findViewById(R.id.textfilebutton);
        starttf.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                starttextfile();
            }
        });

        Button translatetext = (Button) findViewById(R.id.textbutton);
        translatetext.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                translatetext();
            }
        });

        Button retrofitpost = (Button) findViewById(R.id.retrofitbutton);
        retrofitpost.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                testretrofitpost();
            }
        });

    }

    private void startjsonfile() {
        Intent launchjsonfile = new Intent(this, JsonFileActivity.class);
        startActivity(launchjsonfile);
    }

    private void startjsonhttpfile() {
        Intent launchjsonhttpfile = new Intent(this, JsonHttpActivity.class);
        startActivity(launchjsonhttpfile);
    }

    private void starttextfile() {
        Intent launchtextfile = new Intent(this, TextFileActivity.class);
        startActivity(launchtextfile);
    }

    private void translatetext() {
        Intent launchtext = new Intent(this, TranslateTextActivity.class);
        startActivity(launchtext);
    }

    private void testretrofitpost() {
        Intent launchretrofit = new Intent(this, RetrofitPostActivity.class);
        startActivity(launchretrofit);
    }


//    public void redirect(View View)
//    {
//
//        String btnText;
//        btnText =((Button)View).getText().toString();
//        if(btnText.equals("TRANSLATE TEXT FILE"))
//        {
//            Intent tfile = new Intent(this,TRANSLATEFILE.class);
//            startActivity(tfile);
//        }
//        else if (btnText.equals("PARSE JSON FILE"))
//        {
//            Intent jfile= new Intent(this,JSONFILE.class);
//            startActivity(jfile);
//
//        }
//        }
}

