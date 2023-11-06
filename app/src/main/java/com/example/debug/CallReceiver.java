package com.example.debug;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.widget.Toast;

public class CallReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String state = intent.getStringExtra(TelephonyManager.EXTRA_STATE);

        if (state != null && state.equals(TelephonyManager.EXTRA_STATE_RINGING)) {
            String incomingNumber = intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER);
            String message = "Incoming call from: " + incomingNumber;

            Toast.makeText(context, message, Toast.LENGTH_SHORT).show();

            MainActivity mainActivity = (MainActivity) context;
            mainActivity.onIncomingCall(incomingNumber);
        }
    }
}