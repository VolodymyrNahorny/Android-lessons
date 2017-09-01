package ru.startandroid.p0081viewbyid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View myText = findViewById(R.id.myText);
        Button button2 = (Button) findViewById(R.id.button2);
        button2.setEnabled(false);
        CheckBox myChb = (CheckBox) findViewById(R.id.checkBox2);
        myChb.setChecked(true);
    }
}
