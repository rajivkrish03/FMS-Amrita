package com.amrita.fmsamrita;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Notification extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        // add back arrow to toolbar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        Button noti=(Button)findViewById(R.id.button_notification);
        noti.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                createnotification();
            }
        });
    }

    public void createnotification() {

        Intent actionIntent = new Intent(this, Notification.class);

        PendingIntent actionPendingContent = PendingIntent.getActivity(this, 0, actionIntent, PendingIntent.FLAG_CANCEL_CURRENT);

        NotificationCompat.Builder nBuilder = new NotificationCompat.Builder(this);
        nBuilder.setPriority(NotificationCompat.PRIORITY_MAX);
        nBuilder.setContentTitle("FMS Amrita");
        nBuilder.setContentText("Amrita Vishwa Vidyapeetham | Coimbatore");
        nBuilder.setSmallIcon(R.drawable.ic_stat_name);
        nBuilder.setVibrate(new long[] {100, 200, 100, 200});
        nBuilder.addAction(R.drawable.ic_ok, "OK", actionPendingContent);
        nBuilder.setAutoCancel(true);

        android.app.Notification notification = nBuilder.build();
        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        nm.notify(1, notification);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }

        return super.onOptionsItemSelected(item);
    }
}
