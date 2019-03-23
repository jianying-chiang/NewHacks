package com.ramenbois.newhacks.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Camera;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.hardware.camera2.*;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainMenuActivity extends AppCompatActivity {

    private ImageButton mOpenCamera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainmenu);
        addCameraButton();


    }

    private void addCameraButton() {
        mOpenCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = MainMenuActivity.this;
                boolean checkCamera = context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA);
                if (!checkCamera) {
                    Toast.makeText(MainMenuActivity.this, "This device does not have a camera!", Toast.LENGTH_LONG).show();
                } else {

                }
            }
        });
    }
    /* A safe way to get an instance of the Camera object, from
    https://developer.android.com/guide/topics/media/camera#java
    */
    public static Camera getCameraInstance(){
        Camera c = null;
        try {
            c = Camera.open(); // attempt to get a Camera instance
        }
        catch (Exception e){
            // Camera is not available (in use or does not exist)
        }
        return c; // returns null if camera is unavailable
    }


}
