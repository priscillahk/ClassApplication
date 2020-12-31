package com.example.classproject;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.widget.Toast;

public class AlarmBroadcastReciever extends BroadcastReceiver {

    @SuppressLint("MissingPermission")
    @Override
    public void onReceive(Context context, Intent intent) {


        Toast toast=Toast.makeText(context,"Alarm Time Reached",Toast.LENGTH_LONG);
        toast.show();


        Vibrator vibrator=(Vibrator)context.getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(5000);
    }
}
