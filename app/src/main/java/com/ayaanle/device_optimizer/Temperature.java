package com.ayaanle.device_optimizer;

import android.annotation.SuppressLint;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

import java.util.List;

public class Temperature {
    Context context;
    Sensor sensor;
    SensorManager sensorManager;
    List<Sensor>device_sensors;
    SensorEventListener sensor_event;
    public Temperature()
    {

    }
    @SuppressLint("ServiceCast")
    public String Temperature_Sensor()
    {

    }

}
