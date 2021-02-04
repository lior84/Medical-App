package com.example.myapplication;

import android.app.Service;
import android.bluetooth.BluetoothClass;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import java.security.Provider;

/**
 * Created by User on 11/5/2018.
 */

public class RingtonePlayingService extends Service {

    MediaPlayer media_song;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(RingtonePlayingService.this, "This is my Toast message!", Toast.LENGTH_LONG).show();
        media_song = MediaPlayer.create(this, R.raw.c1);
        media_song.start();
        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        // Tell the user we stopped.
        Toast.makeText(getApplicationContext(), "on Destroy called", Toast.LENGTH_LONG).show();
    }
}
