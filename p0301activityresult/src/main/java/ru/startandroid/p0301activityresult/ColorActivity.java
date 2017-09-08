package ru.startandroid.p0301activityresult;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by dell on 06.09.17.
 */

public class ColorActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnRed, btnGreen, btnBlue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.color);

        btnBlue = (Button) findViewById(R.id.btnBlue);
        btnGreen = (Button) findViewById(R.id.btnGreen);
        btnRed = (Button) findViewById(R.id.btnRed);

        btnBlue.setOnClickListener(this);
        btnGreen.setOnClickListener(this);
        btnRed.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.btnBlue:
                intent.putExtra("color", Color.BLUE);
                break;
            case R.id.btnGreen:
                intent.putExtra("color", Color.GREEN);
                break;
            case R.id.btnRed:
                intent.putExtra("color", Color.RED);
                break;
        }
        setResult(RESULT_OK, intent);
        finish();
    }
}
