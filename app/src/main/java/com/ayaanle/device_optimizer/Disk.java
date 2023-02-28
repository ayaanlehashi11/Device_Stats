package com.ayaanle.device_optimizer;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.appsearch.StorageInfo;
import android.app.usage.StorageStats;
import android.app.usage.StorageStatsManager;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Environment;
import android.os.storage.StorageManager;
import android.os.storage.StorageVolume;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

import java.io.File;
import java.util.List;

@RequiresApi(api = Build.VERSION_CODES.N)
public class Disk implements AlarmManager.OnAlarmListener , DialogInterface.OnClickListener  {
    Context context;
    boolean removable;
    long free_space , total_space , usable_space;
    StorageManager storage_manager = (StorageManager)context.getSystemService(Context.STORAGE_SERVICE);
    StorageVolume volume = storage_manager.getPrimaryStorageVolume();
    @RequiresApi(api = Build.VERSION_CODES.R)
    public int disk_usage(int size , boolean encrypted)
    {
        File _directory = Environment.getDataDirectory();
        if(storage_manager.isEncrypted(volume.getDirectory()))
            encrypted = true;
        else
            encrypted = false;
        if(volume.isPrimary() && !volume.isRemovable())
        {
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.R) {
                File directory = volume.getDirectory();
                if(directory.isAbsolute() && !directory.isHidden())
                {
                    free_space = directory.getFreeSpace();
                    total_space = directory.getTotalSpace();
                    usable_space = directory.getUsableSpace();
                    Thread th = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            if(usable_space >= total_space)
                            {

                            }
                        }
                    });
                }
            }
        }
        else if(Environment.isExternalStorageRemovable())
            Toast.makeText(context.getApplicationContext(), "the external storage is emulated" , Toast.LENGTH_SHORT).show();
    }
    public String disk_info()
    {
        String root;

    }
    public List<String> absolute_paths(List<String>abs_paths , boolean encrypted)
    {
        List<StorageVolume> list_volumes = storage_manager.getStorageVolumes();
        for(int i = 0; i <list_volumes.size();++i)
        {

        }
    }
    @SuppressLint("UsableSpace")
    public int getNumberOfPartitions()
    {
        removable = Environment.isExternalStorageRemovable(Environment.getRootDirectory());
        String chech_if_removable = removable ? "is removable":"is not removable";
        return 0;
    }
    public AlertDialog DiskDialog()
    {
        return new AlertDialog();
    }

    @Override
    public void onAlarm() {

    }

    @Override
    public void onClick(DialogInterface dialogInterface, int i) {

    }
}
