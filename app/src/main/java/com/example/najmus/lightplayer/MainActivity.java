package com.example.najmus.lightplayer;
/*====================================
    Author : NAJMUS SEEMAB
======================================*/

import android.app.Service;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements SensorEventListener{
    SensorManager sensorManager;
    Sensor sensor;
    boolean isRunning = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );
        sensorManager = (SensorManager) getSystemService( Service.SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
    }
    protected void onResume(){
        super.onResume();
        sensorManager.registerListener(this,sensor,SensorManager.SENSOR_DELAY_NORMAL);
    }
    protected void onPause() {
        super.onPause ();

        sensorManager.unregisterListener ( this );

    }

    MediaPlayer mp;

    public void onSensorChanged(SensorEvent event) {

        if (event.values[0] > 20 && isRunning == false) {
            isRunning = true;
            try {
                mp.setDataSource ( "http://WWW.hungama.com/album/baaghi-2/33939236/" );
                mp.prepare ();
                mp.start ();
            } catch (Exception ex) {
                //play the music
            }


        }


    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
