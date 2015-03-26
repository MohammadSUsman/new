package com.example.mohammadsulamanusman.senserofyourmobile;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    //variables
    private ListView listView;
    private SensorManager mSensorManager;
    //list of sensors
    private List<Sensor> deviceSensors = null;
    //list of sensors names
    private List<String> deviceSensorsList = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //create instance of list view
        listView = ((ListView) findViewById(R.id.listView1));
        //create instance of sensor manager and get system sensor service
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        //get list of all types of sensors in you device
        deviceSensors = mSensorManager.getSensorList(Sensor.TYPE_ALL);
  /*you can get specific sensors by selecting type in getSensorList(type you want);*/
        for(Sensor s: deviceSensors){
            //get names of all the sensors in your device and add into list
            deviceSensorsList.add(s.getName());
        }
        listView.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, deviceSensorsList));
    }
}
