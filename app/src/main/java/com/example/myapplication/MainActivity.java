package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
   // static String password;
    static String ip = "10.40.0.40";
    static int port = 8888;
   // String message = "lior";
  //  TextView response;
  //  EditText editTextAddress, editTextPort;
    Button buttonConnect;//, buttonClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

     //   editTextAddress = (EditText) findViewById(R.id.addressEditText);
     //   editTextPort = (EditText) findViewById(R.id.portEditText);
        buttonConnect = (Button) findViewById(R.id.connectButton);
     //   buttonClear = (Button) findViewById(R.id.clearButton);
     //   response = (TextView) findViewById(R.id.responseTextView);

        buttonConnect.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
            //    ip = editTextAddress.getText().toString();
                //Client myClient = new Client(editTextAddress.getText().toString(), Integer.parseInt(editTextPort.getText().toString()), response, message);
                //Client myClient = new Client("192.168.43.83", 9999, response, null);
                //myClient.getConnected();


                Intent logIn = new Intent(MainActivity.this, LoginActivity.class);

                //   Bundle bundle = new Bundle();
                //   logIn.putExtras(bundle);

                startActivity(logIn);
                // myClient.sendMessage();
                //String email = logIn.getStringExtra("Email");
                //String pass = logIn.getStringExtra("Pass");
                //Log.d("Values", email+pass);
                //Log.d("passe:", password);
            }

        });

/*
        buttonClear.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                response.setText("");

            }
        });*/
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 2) {
            if(resultCode == Activity.RESULT_OK){
                String result=data.getStringExtra("result");
                String email = getIntent().getExtras().get("Email").toString();
                String pass = getIntent().getExtras().get("pass").toString();
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                //Write your code if there's no result
            }
        }
    }//onActivityResult

}