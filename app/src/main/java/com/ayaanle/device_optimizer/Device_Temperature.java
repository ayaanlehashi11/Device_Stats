package com.ayaanle.device_optimizer;
import android.hardware.BatteryState;
import android.os.Build;
import android.os.CpuUsageInfo;
import android.os.health.HealthStats;
import android.os.health.UidHealthStats;
import android.os.health.SystemHealthManager;
import android.os.HardwarePropertiesManager;
import android.system.SystemCleaner;

import androidx.annotation.RequiresApi;

public class Device_Temperature {
    public static HealthStats healthStats;
    public BatteryState batteryState;
    public Battery Battery;
    SystemCleaner systemCleaner;
    float[] fan_speeds;
    CpuUsageInfo [] cpu_usage;
    HardwarePropertiesManager hardwarePropertiesManager;
    SystemHealthManager systemHealthManager;
    public Device_Temperature()
    {

    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    public int device_temperature()
    {
        cpu_usage = hardwarePropertiesManager.getCpuUsages();
        healthStats = systemHealthManager.takeMyUidSnapshot();
        if(healthStats.hasStats(UidHealthStats.MEASUREMENT_USER_CPU_TIME_MS) && healthStats.hasMeasurement(UidHealthStats.))
        {
            fan_speeds = hardwarePropertiesManager.getFanSpeeds();
        }
    }
}
