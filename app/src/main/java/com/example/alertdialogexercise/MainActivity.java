package com.example.alertdialogexercise;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    Button buttonSettings;
    Button buttonEmergency;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences("ANDROIDCLASS", MODE_PRIVATE);
        buttonSettings = findViewById(R.id.buttonSettings);
        buttonEmergency = findViewById(R.id.buttonEmergency);

    }

    @Override
    public void onResume(){
        super.onResume();
        //Toast.makeText(getApplicationContext(), "This is onResume()", Toast.LENGTH_LONG).show();

    }

    @Override
    public void onStart() {
        super.onStart();
        //sharedPreferences = getSharedPreferences("ANDROIDCLASS", MODE_PRIVATE);
        //Toast.makeText(getApplicationContext(), sharedPreferences.getString("medical", "Nothing found."), Toast.LENGTH_LONG).show();
        //Toast.makeText(getApplicationContext(), "This is onStart()", Toast.LENGTH_LONG).show();

    }
    public void onSettingsButtonClick(View view){
        Intent intent = new Intent(getApplicationContext(), SettingsActivty.class);
        startActivity(intent);
    }

    public void onEmergencyClick(View view){
        sharedPreferences = getSharedPreferences("ANDROIDCLASS", MODE_PRIVATE);
        //Toast.makeText(getApplicationContext(), sharedPreferences.getString("medical", "Nothing found."), Toast.LENGTH_LONG).show();
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Make Emergency Call");
        //EditText userInput = new EditText(MainActivity.this);
        ListView emergencyCallListView = new ListView(this);
        emergencyCallListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "Item was clicked.", Toast.LENGTH_LONG).show();
                AlertDialog.Builder builder2 = new AlertDialog.Builder(MainActivity.this);
                builder2.setTitle("Confirm emergency call now:");
                builder2.setPositiveButton("Call", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "Calling....", Toast.LENGTH_LONG).show();
                    }
                });
                builder2.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                builder2.show();
            }
        });
//        ArrayList<String> callOptions = new ArrayList<>();
//        callOptions.add("one");
//        callOptions.add("two");
//        callOptions.add("three");
//        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.emergency_call_list_item, R.id.tvDialog, callOptions);
        List<EmergencyContact> emergencyContactList = new ArrayList<>();
        emergencyContactList.add(new EmergencyContact("Medical", R.drawable.medical, sharedPreferences.getString("medical", "error")));
        emergencyContactList.add(new EmergencyContact("Fire", R.drawable.fire, sharedPreferences.getString("fire", "error")));
        emergencyContactList.add(new EmergencyContact("Accident", R.drawable.accident, sharedPreferences.getString("accident", "error")));
        emergencyContactList.add(new EmergencyContact("Police", R.drawable.police, sharedPreferences.getString("police", "error")));
        //ArrayAdapter adapter = new ArrayAdapter(this, R.layout.emergency_call_list_item, emergencyContactList);
        CustomAdapter adapter = new CustomAdapter(this, emergencyContactList);
        emergencyCallListView.setAdapter(adapter);
        builder.setView(emergencyCallListView);

        builder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.show();
    }
}