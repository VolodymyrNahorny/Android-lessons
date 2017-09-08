package ru.startandroid.p0271getintentaction;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Info extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info);

        Intent intent = getIntent();
        String action = intent.getAction();
        String format = "";
        String textInfo = "";
        if (action.equals("ru.startandroid.intent.action.showtime")) {
            format = "HH:mm:ss";
            textInfo = "Time: ";
        }
        if (action.equals("ru.startandroid.intent.action.showdate")) {
            format = "dd:MM:YYYY";
            textInfo = "Date: ";
        }

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        String datetime = simpleDateFormat.format(new Date(System.currentTimeMillis()));

        TextView textView = (TextView) findViewById(R.id.tvInfo);
        textView.setText(textInfo + datetime);
    }
}
