package com.example.sensoraccelerometer;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

// Don't forget to implement from SensorEventListener

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    // Initializing variables

    Sensor accelerometer;
    SensorManager sm;
    TextView aclrtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sm = (SensorManager) getSystemService(SENSOR_SERVICE);
        accelerometer = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sm.registerListener(this,accelerometer,SensorManager.SENSOR_DELAY_NORMAL);

        // to display
        aclrtn = (TextView) findViewById(R.id.acceleration);


    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        aclrtn.setText("\nX:"+event.values[0] + "\nY:"+event.values[1] + "\nZ:"+event.values[2] );

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}