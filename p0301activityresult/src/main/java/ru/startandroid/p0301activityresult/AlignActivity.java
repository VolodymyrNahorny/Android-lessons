package ru.startandroid.p0301activityresult;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;

/**
 * Created by dell on 06.09.17.
 */

public class AlignActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnLeft, btnCenter, btnRight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.align);

        btnLeft = (Button) findViewById(R.id.btnLeft);
        btnCenter = (Button) findViewById(R.id.btnCenter);
        btnRight = (Button) findViewById(R.id.btnRight);

        btnLeft.setOnClickListener(this);
        btnCenter.setOnClickListener(this);
        btnRight.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.btnLeft:
                intent.putExtra("align", Gravity.LEFT);
                break;
            case R.id.btnCenter:
                intent.putExtra("align", Gravity.CENTER);
                break;
            case R.id.btnRight:
                intent.putExtra("align", Gravity.RIGHT);
                break;
        }
        setResult(RESULT_OK, intent);
        finish();
    }
}
