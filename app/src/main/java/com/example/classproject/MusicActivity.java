package com.example.classproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MusicActivity extends AppCompatActivity implements View.OnClickListener {

    // declaring objects of Button class
    private Button startPlayerButton, stopPlayerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        // assigning ID of startButton
        // to the object start
        startPlayerButton = (Button) findViewById( R.id.startPlayButton);

        // assigning ID of stopButton
        // to the object stop
        stopPlayerButton = (Button) findViewById( R.id.stopPlayButton);

        // declaring listeners for the
        // buttons to make them respond
        // correctly according to the process
        startPlayerButton.setOnClickListener( this );
        stopPlayerButton.setOnClickListener( this );
    }

    public void onClick(View view) {
        // process to be performed
        // if start button is clicked
        if(view == startPlayerButton){

            // starting the service
            startService(new Intent( this, PlayerService.class ) );
        }

        // process to be performed
        // if stop button is clicked
        else if (view == stopPlayerButton){

            // stopping the service
            stopService(new Intent( this, PlayerService.class ) );

        }
    }

        public void triggerAlarm(View view) {
            Toast.makeText(this, "Alarm Set Successfully. Wait for 5 seconds", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), AlarmBroadcastReciever.class);
                PendingIntent pendingIntent;
                pendingIntent = PendingIntent.getBroadcast(this.getApplicationContext(), 0, intent, 0);
                AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + 5000, pendingIntent);
    }

    public void openListActivity(View view) {
        Toast.makeText(this, "Activity Started", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(MusicActivity.this,SongsList.class));

    }
}


