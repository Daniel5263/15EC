package com.example.debug;


import androidx.appcompat.app.AppCompatActivity;

import androidx.core.content.ContextCompat;
import android.Manifest;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private TextView callInfoTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        callInfoTextView = findViewById(R.id.callInfoTextView);

        if (checkPermissions()) {}
    }

    private boolean checkPermissions() {
        int readPhoneStatePermission = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE);
        int processOutgoingCallsPermission = ContextCompat.checkSelfPermission(this, Manifest.permission.PROCESS_OUTGOING_CALLS);

        return readPhoneStatePermission == PackageManager.PERMISSION_GRANTED && processOutgoingCallsPermission == PackageManager.PERMISSION_GRANTED;
    }


    public void onIncomingCall(String incomingNumber) {
        String message = "Incoming call from: " + incomingNumber;
        callInfoTextView.setText(message);
    }
}