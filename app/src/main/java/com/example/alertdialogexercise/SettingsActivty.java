package com.example.alertdialogexercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SettingsActivty extends AppCompatActivity {

    EditText editTextMedical;
    EditText editTextFire;
    EditText editTextAccident;
    EditText editTextPolice;

    Button saveButton;
    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_activty);

        editTextMedical = findViewById(R.id.etMedical);
        editTextFire = findViewById(R.id.etFire);
        editTextAccident = findViewById(R.id.etAccident);
        editTextPolice = findViewById(R.id.etPolice);
        saveButton = findViewById(R.id.buttonSave);

        sharedPreferences = getSharedPreferences("ANDROIDCLASS", MODE_PRIVATE);
        if(sharedPreferences.contains("medical")){
            editTextMedical.setText(sharedPreferences.getString("medical", ""));
        }
        if(sharedPreferences.contains("fire")){
            editTextFire.setText(sharedPreferences.getString("fire", ""));
        }
        if(sharedPreferences.contains("accident")){
            editTextAccident.setText(sharedPreferences.getString("accident", ""));
        }
        if(sharedPreferences.contains("police")){
            editTextPolice.setText(sharedPreferences.getString("police", ""));
        }
    }

    public void onSaveClick(View view){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("medical", editTextMedical.getText().toString());
        editor.putString("fire", editTextFire.getText().toString());
        editor.putString("accident", editTextAccident.getText().toString());
        editor.putString("police", editTextPolice.getText().toString());
        editor.apply();
        finish();
    }
}