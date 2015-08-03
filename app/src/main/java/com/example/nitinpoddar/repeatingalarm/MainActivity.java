package com.example.nitinpoddar.repeatingalarm;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

    private EditText mtxtInput;
    private Button btnOneShot, btnRepeatAlarm, btnStopRepeatingAlarm;
    private PendingIntent pi;
    private AlarmManager am;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mtxtInput = (EditText) findViewById(R.id.txtInput);
        btnOneShot = (Button) findViewById(R.id.btnOneShot);
        btnRepeatAlarm = (Button) findViewById(R.id.btnRepeatAlarm);
        btnStopRepeatingAlarm = (Button)findViewById(R.id.btnStopRepeatingAlarm);
    }
    public void oneShotAlarm(View v){
        int i = Integer.parseInt(mtxtInput.getText().toString());
        Intent intent = new Intent(this, AlarmReceiver.class);
        pi = PendingIntent.getActivity(this, 2, intent, PendingIntent.FLAG_CANCEL_CURRENT);
        am = (AlarmManager) getSystemService(ALARM_SERVICE);
        am.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + (i*1000), pi);

    }
    public void repeatAlarm(View v){
        int i = Integer.parseInt(mtxtInput.getText().toString());
        Intent intent = new Intent(this, AlarmReceiver.class);
        pi = PendingIntent.getActivity(this, 3, intent, PendingIntent.FLAG_CANCEL_CURRENT);
        am = (AlarmManager) getSystemService(ALARM_SERVICE);
        am.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + (i * 1000), (15 * 1000), pi);
       // am.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + (i * 1000), pi);
    }

    public void stopRepeatingAlarm(View v){
       // Intent intent = new Intent(this, RepeatingAlarmReceiver.class);
      //  PendingIntent pi = PendingIntent.getActivity(this, 3, intent, PendingIntent.FLAG_CANCEL_CURRENT);
      //  AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);
        am.cancel(pi);
    }

}
