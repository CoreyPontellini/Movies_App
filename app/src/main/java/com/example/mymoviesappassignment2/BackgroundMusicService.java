package com.example.mymoviesappassignment2;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import androidx.annotation.Nullable;

public class BackgroundMusicService extends Service {

    MediaPlayer musicPlayer;

    // add background service class to house a music player

    @Override
    public int onStartCommand(Intent intent, int flags, int startId){

        musicPlayer = MediaPlayer.create(this,R.raw.backgroundmusic);
        musicPlayer.start();
        musicPlayer.setLooping(true);
        return START_NOT_STICKY;
    }
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {return null;}

    // on app closing confirm that the play is already not null to avoid exception
    // stop/release/set to null player on close to eliminate resource consumption
    @Override
    public void onDestroy() {
        super.onDestroy();
        if (musicPlayer != null) {
            musicPlayer.stop();
            musicPlayer.release();
            musicPlayer = null;
        }

    }

}
