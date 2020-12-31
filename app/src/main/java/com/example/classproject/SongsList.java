package com.example.classproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SongsList extends AppCompatActivity {
    EditText title,art,chro;
    Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_songs_list);
        title =findViewById(R.id.song_title);
        art =findViewById(R.id.song_artist);
        chro =findViewById(R.id.song_chorus);

    }

    public void saveSong(View view) {
        String tit=title.getText().toString().trim();
        String ar=art.getText().toString().trim();
        String cho=chro.getText().toString().trim();
        if (TextUtils.isEmpty(tit) || TextUtils.isEmpty(ar)  || TextUtils.isEmpty(cho) ){
            Toast.makeText(this, "Empty Inputs cannot be saved", Toast.LENGTH_SHORT).show();
        }
        else{
            SqliteHelper helper =new SqliteHelper(SongsList.this);
            boolean check_save=helper.saveSong(tit,ar,cho);
            if (check_save){
                Toast.makeText(this, "Song Recorded Successfully. Previous Entries Cleared", Toast.LENGTH_SHORT).show();
                clearTxt();
            }else{
                Toast.makeText(this, "Couldn't save. Something Wrong Just Happened", Toast.LENGTH_SHORT).show();
            }

        }


    }

    private void clearTxt(){
        title.setText("");
        art.setText("");
        chro.setText("");

    }

}