package com.ayaanle.device_optimizer;

import android.app.AlertDialog;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.ayaanle.device_optimizer.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.Toast;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
    AlertDialog dialog;
    ImageButton imgbtn1;
    ImageButton imgbtn2;
    ImageButton imgbtn3;
    ImageButton imgbtn4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        Toolbar tool_bar = (Toolbar)findViewById(R.id.toolbar);
        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        imgbtn1 = (ImageButton) findViewById(R.id.imageButton);
        imgbtn2 = (ImageButton) findViewById(R.id.imageButton2);
        imgbtn3 = (ImageButton) findViewById(R.id.imageButton3);
        imgbtn4 = (ImageButton) findViewById(R.id.imageButton4);
        imgbtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        imgbtn3.setOnClickListener(view ->
                Toast.makeText(getApplicationContext() , "disk" , Toast.LENGTH_SHORT).show());
        imgbtn2.setOnClickListener(view ->
                Toast.makeText(getApplicationContext() , "battery" , Toast.LENGTH_SHORT).show());
        imgbtn1.setOnClickListener(view ->
                Toast.makeText(getApplicationContext() , "Wifi" , Toast.LENGTH_SHORT).show());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}