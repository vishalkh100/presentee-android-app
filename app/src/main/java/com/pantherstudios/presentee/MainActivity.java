package com.pantherstudios.presentee;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.pantherstudios.presentee.Functions.DataGetSet;

public class MainActivity extends AppCompatActivity {

    private static final int MY_CAMERA_REQUEST_CODE = 100;
    private Button scanInButton;
    private Button scanOutButton;
    private Button sectionButton;
    private TextView selectedSectionName;

    public static DataGetSet dataGetSet = new DataGetSet();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scanInButton = findViewById(R.id.scanInButton);
        scanOutButton = findViewById(R.id.scanOutButton);
        sectionButton = findViewById(R.id.sectionButton);
        selectedSectionName = findViewById(R.id.textView);

        if(dataGetSet.getSelectedSection()!=null) {
            Log.d("DataGetSet", dataGetSet.getSelectedSection().name);
            selectedSectionName.setText("Selected Section: " + dataGetSet.getSelectedSection().name);
        } else {
            Log.d("DataGetSet", "null");
        }

        scanInButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent myIntent = new Intent(MainActivity.this, ScannerActivity.class);
                        MainActivity.this.startActivity(myIntent);
                    }
                }
        );

        scanOutButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent myIntent = new Intent(MainActivity.this, ScanOutActivity.class);
                        MainActivity.this.startActivity(myIntent);
                    }
                }
        );

        sectionButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent myIntent = new Intent(MainActivity.this, SelectSectionActivity.class);
                        MainActivity.this.startActivity(myIntent);
                    }
                }
        );

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                == PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(MainActivity.this, new String[] {Manifest.permission.CAMERA}, MY_CAMERA_REQUEST_CODE);
        }

    }

}