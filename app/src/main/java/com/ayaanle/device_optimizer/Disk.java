//package com.ayaanle.device_optimizer;
//
//import android.app.AlertDialog;
//import android.content.Context;
//import android.os.Build;
//import android.os.Environment;
//import android.os.storage.StorageManager;
//import android.os.storage.StorageVolume;
//import android.widget.Toast;
//
//import androidx.annotation.RequiresApi;
//
//import java.io.File;
//import java.util.List;
//
//@RequiresApi(api = Build.VERSION_CODES.N)
//public class Disk {
//    Context context;
//    StorageManager storage_manager = (StorageManager)context.getSystemService(Context.STORAGE_SERVICE);
//    StorageVolume volume = storage_manager.getPrimaryStorageVolume();
//    @RequiresApi(api = Build.VERSION_CODES.R)
//    public int disk_usage(int size , boolean encrypted)
//    {
//        File _directory = Environment.getDataDirectory();
//        if(storage_manager.isEncrypted())
//            encrypted = true
//        else
//            encrypted = false;
//    }
//    public String disk_info()
//    {
//        String root;
//
//    }
//    public List<String> absolute_paths(List<String>abs_paths , boolean encrypted)
//    {
//
//    }
//    public int getNumberOfPartitions()
//    {
//
//        if(volume.isPrimary() && !volume.isRemovable())
//        {
//            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.R) {
//                File directory = volume.getDirectory();
//            }
//        }
//        else if(Environment.isExternalStorageRemovable()){
//            Toast.makeText(context.getApplicationContext(), "the external storage is emulated" , Toast.LENGTH_SHORT).show();
//        }
//    }
//    public AlertDialog DiskDialog()
//    {
//        return new AlertDialog();
//    }
//}
