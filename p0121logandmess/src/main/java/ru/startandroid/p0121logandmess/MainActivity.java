package ru.startandroid.p0121logandmess;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    TextView textView;
    Button buttonOk;
    Button buttonCancel;
    public static final String TAG = "mylogs";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "finding view elements");
        textView = (TextView) findViewById(R.id.tvOut);
        buttonOk = (Button) findViewById(R.id.btnOk);
        buttonCancel = (Button) findViewById(R.id.btnCancel);
        Log.d(TAG, "setting on click listener to views");
        textView.setOnClickListener(this);
        buttonCancel.setOnClickListener(this);
        buttonOk.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnCancel:
                Log.d(TAG, "najali Cancel");
                textView.setText("Btn Cancel!");
                Toast.makeText(this, "najali Cancel", Toast.LENGTH_LONG).show();
                break;
            case R.id.btnOk:
                Log.d(TAG, "najali ok");
                textView.setText("Btn Ok!");
                Toast.makeText(this, "najali Ok", Toast.LENGTH_LONG).show();
                break;
        }
    }
}
