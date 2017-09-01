package ru.startandroid.p0101listener;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView textView = (TextView) findViewById(R.id.text);
        Button ok = (Button) findViewById(R.id.ok);
        Button cancel = (Button) findViewById(R.id.cancel);

        View.OnClickListener odinListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.ok:
                        textView.setText("Ok nazhal!");
                        break;
                    case R.id.cancel:
                        textView.setText("Cancel nazhal!");
                        break;
                }
            }
        };
        ok.setOnClickListener(odinListener);
        cancel.setOnClickListener(odinListener);
    }
}
