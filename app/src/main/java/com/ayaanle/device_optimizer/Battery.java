package com.ayaanle.device_optimizer;

import android.annotation.SuppressLint;
import android.app.ApplicationErrorReport;
import android.content.Context;
import android.os.Build;
import android.os.BatteryManager;
import android.os.PowerManager;
import android.os.PowerManager.OnThermalStatusChangedListener;
import android.hardware.BatteryState;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.hardware.SensorAdditionalInfo;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

import java.time.Duration;

@RequiresApi(api = Build.VERSION_CODES.Q)
public class Battery {
    Context context;
    PowerManager power_manager;
    Duration battery_life_prediction;
    BatteryState batterState;
    {
        assert false;
        power_manager = (PowerManager) context.getApplicationContext().getSystemService(Context.POWER_SERVICE);
    }

    public Battery(){

    }

    /**
     *
     * @param temperature
     * @param duration
     * @return
     */
    float device_temperature(float temperature , int duration)
    {
        if(power_manager.getCurrentThermalStatus() == PowerManager.THERMAL_STATUS_MODERATE){

        }
        @SuppressLint({"NewApi", "LocalSuppress"})
        float thermal_headroom = power_manager.getThermalHeadroom(10000);
        return thermal_headroom;
    }

    /**
     *
     * @param temperature
     * @param battery_life
     * @return
     */
    @SuppressLint("NewApi")
    public int getBatteryLife(int temperature,
                              float battery_life)
    {
        power_manager.addThermalStatusListener(thermal_listener);
        battery_life_prediction = power_manager.getBatteryDischargePrediction();

        if (!power_manager.isPowerSaveMode() && power_manager.getCurrentThermalStatus() == PowerManager.THERMAL_STATUS_EMERGENCY) {
            power_manager.getCurrentThermalStatus();
        }
        BatteryManager _battery_manager = (BatteryManager) context.getSystemService(Context.BATTERY_SERVICE);
        if(_battery_manager.isCharging()){
            String battery_state = "Is Charging";
        }
        long battery_remaining_charge = _battery_manager.computeChargeTimeRemaining();
        ApplicationErrorReport.BatteryInfo info = new ApplicationErrorReport.BatteryInfo();
        info.
    }
    public static  class Cpu {
        public Cpu()
        {

        }

        /**
         *
         * @param opening_time is the time that the
         * device's cpu was open since booting
         */
        public Cpu(long opening_time){

        }
        public static String cpu_info()
        {
            return null;
        }
        public double get_cpu_temperature()
        {

        }
        public double get_cpu_frequency()
        {

        }
    }
    public interface TemperatureListener
    {

    }
    enum TEMP_SCALE{
        CELCIUS,
        FAHRENHEIT
    }
}
