package com.ayaanle.device_optimizer;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.ApplicationErrorReport;
import android.content.Context;
import android.os.Build;
import android.os.BatteryManager;
import android.os.PowerManager;
import android.os.PowerManager.OnThermalStatusChangedListener;
import android.hardware.BatteryState;
import com.ayaanle.device_optimizer.Device_Temperature;
import com.ayaanle.device_optimizer.Utils;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

import java.time.Duration;

@RequiresApi(api = Build.VERSION_CODES.Q)
public class Battery implements OnThermalStatusChangedListener, AlarmManager.OnAlarmListener {
    PowerManager power_manager;
    Duration battery_life_prediction;
    boolean is_charging , is_full;
    BatteryState batteryState;
    {
        assert false;
    }

    public Battery(Context context){
        power_manager = (PowerManager) context.getApplicationContext().getSystemService(Context.POWER
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
        float thermal_headroom = power_manager.getThermalHeadroom(3);
        return thermal_headroom;
    }

    /**
     *
     * @param temperature: the temperature of the battery
     * @param battery_life: the expected life of the battery if such an usage is kept constant
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
    @RequiresApi(api = Build.VERSION_CODES.S)
    public synchronized double BatteryAmount()
    {
        double battery_capacity = batteryState.getCapacity();
        batteryState.getStatus();
        return battery_capacity;
    }
    @Override
    public void onThermalStatusChanged(int i) {

    }

    @Override
    public void onAlarm() {

    }

    public static  class Cpu {
        public Cpu()
        {

        }
        /**
         *
         * @param arch_type
         * @param opening_time
         */
        public Cpu(String arch_type , long opening_time){

        }

        /**
         *
         * @return String info about cpu operation
         */
        public synchronized String cpu_info()
        {
            String cpu_temperature = String.valueOf(get_cpu_temperature());
            String cpu_frequency = String.valueOf(get_cpu_frequency())
            return null;
        }
        public double get_cpu_temperature()
        {
            return 0;
        }
        public double get_cpu_frequency()
        {
            return 0;
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
