package com.trinkmobiles.notificationexample;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class SecondActivity extends Activity {

    private TextView txtMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        txtMessage = (TextView) findViewById(R.id.message);

        txtMessage.setText(getIntent().hasExtra("msg") ?
                            getIntent().getStringExtra("msg") :
                            "No Message");
    }

}
