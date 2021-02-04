package com.example.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by User on 11/5/2018.
 */

public class Alarm_Reciever extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        Log.e("We yey", "yr");

        Intent service_intent = new Intent(context, RingtonePlayingService.class);
        context.startService(service_intent);
    }
}
