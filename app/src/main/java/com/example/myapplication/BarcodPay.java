package com.example.myapplication;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;

public class BarcodPay extends AppCompatActivity implements View.OnClickListener{

    private Button scanBtn;
    private TextView titlesTxt, contentTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barcod_pay);

        scanBtn = (Button) findViewById(R.id.scan_button);
        titlesTxt = (TextView) findViewById(R.id.titels);
        contentTxt = (TextView) findViewById(R.id.content);

        scanBtn.setOnClickListener(this);

        java.text.DateFormat dateFormat = android.text.format.DateFormat.getDateFormat(getApplicationContext());

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void onClick(View v){
        //respond to clicks
        if(v.getId()==R.id.scan_button){
            //scan
            IntentIntegrator scanIntegrator = new IntentIntegrator(this);
            scanIntegrator.initiateScan();
        }
    }

    //Global.
    Map<String, String> map = new HashMap<String, String>();
    String result = "";


    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
    //retrieve scan result
        IntentResult scanningResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
        if (scanningResult != null) {
            //we have a result
        }
        else{
            Toast toast = Toast.makeText(getApplicationContext(),
                    "No scan data received!", Toast.LENGTH_SHORT);
            toast.show();
        }
        String scanContent = scanningResult.getContents();

        if(scanContent.equals("7290004078942")) {
            map.put("1","Deodorant -- 10$\n");
        }

        titlesTxt.setText("Buying List: ");
        for (int i = 1; i <= map.size() ; i++)
           result += "# "+ map.get(String.valueOf(i));
        contentTxt.setText(result);


    }

}
