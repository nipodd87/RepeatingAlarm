package com.example.nitinpoddar.repeatingalarm;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

/**
 * Created by nitinpoddar on 8/3/15.
 */
public class RepeatingAlarmReceiver extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.receiver_alarm);

    }
    public void stopAlarm(View v){
        finish();
    }
}
