package ru.startandroid.p0301activityresult;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    final int REQUEST_CODE_COLOR = 1;
    final int REQUEST_CODE_ALIGN = 2;

    TextView textView;
    Button btnColor, btnAlign;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.tvText);
        btnAlign = (Button) findViewById(R.id.btnAlign);
        btnColor = (Button) findViewById(R.id.btnColor);

        btnAlign.setOnClickListener(this);
        btnColor.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.btnColor:
                intent = new Intent(this, ColorActivity.class);
                startActivityForResult(intent, REQUEST_CODE_COLOR);
                break;
            case R.id.btnAlign:
                intent = new Intent(this, AlignActivity.class);
                startActivityForResult(intent, REQUEST_CODE_ALIGN);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.d("myLog", "request_code = " + requestCode + "  |  result_code = " + resultCode);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case REQUEST_CODE_COLOR:
                    textView.setTextColor(data.getIntExtra("color", Color.WHITE));
                    break;
                case REQUEST_CODE_ALIGN:
                    textView.setGravity(data.getIntExtra("align", Gravity.LEFT));
                    break;
            }
        } else {
            Toast.makeText(this, "Wrong RESULT_CODE", Toast.LENGTH_LONG).show();
        }
    }
}
