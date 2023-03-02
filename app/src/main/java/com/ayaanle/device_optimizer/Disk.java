package com.ayaanle.device_optimizer;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Environment;
import android.os.storage.StorageManager;
import android.os.storage.StorageVolume;
import android.widget.RemoteViews;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

import java.io.File;
import java.util.List;

@RequiresApi(api = Build.VERSION_CODES.N)
public class Disk implements AlarmManager.OnAlarmListener , DialogInterface.OnClickListener  {
    Context context;
    boolean removable;
    NotificationManager notificationManager;
    public NotificationChannel notificationChannel;
    Notification.Builder builder;
    private final String description = "Test Notification";
    private final String channelId = "i.apps.notification";
    long free_space , total_space , usable_space;
    String [] paths;
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
    public String[] absolute_paths(List<String>abs_paths , boolean encrypted)
    {
        List<StorageVolume> list_volumes = storage_manager.getStorageVolumes();
        for(int i = 0; i <list_volumes.size();++i)
        {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                String media_storage = list_volumes.get(i).getMediaStoreVolumeName();
            }
            paths[i] = String.valueOf(list_volumes.get(i));

        }
        return paths;
    }
    @SuppressLint("UsableSpace")
    public int getNumberOfPartitions()
    {
        removable = Environment.isExternalStorageRemovable(Environment.getRootDirectory());
        String chech_if_removable = removable ? "is removable":"is not removable";
        return 0;
    }
    public  NotificationManager DiskAlertNotification()
    {
        Intent intent = new Intent(context.getApplicationContext() , NotifActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context.getApplicationContext() , 0 , intent , PendingIntent.FLAG_UPDATE_CURRENT);
        RemoteViews contentView = new RemoteViews(context.getPackageName() , R.layout.activity_main);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notificationChannel = new NotificationChannel(channelId , description , NotificationManager.IMPORTANCE_HIGH);
            notificationChannel.enableLights(true);
            notificationChannel.enableVibration(true);
            notificationManager.createNotificationChannel(notificationChannel);
            builder = new Notification.Builder(context.getApplicationContext(), channelId);
            builder.setContent(contentView);
            builder.setSmallIcon(R.drawable.notification);
            builder.setLargeIcon(BitmapFactory.decodeResource(getApplicationContext().getResources() , R.drawable.ic_launcher_background));
            builder.setContentIntent(pendingIntent);
        }
        else
        {
            builder = new Notification.Builder(getApplicationContext())
                    .setContent(contentView)
                    .setSmallIcon(R.drawable.ic_launcher_background)
                    .setLargeIcon(BitmapFactory.decodeResource(getApplicationContext().getResources() , R.drawable.ic_launcher_background))
                    .setContentIntent(pendingIntent);
        }
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
