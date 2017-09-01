package ru.startandroid.p0181dynamiclayout3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener{

    SeekBar sbWeight;
    Button btn1, btn2;
    LinearLayout.LayoutParams lParams1, lParams2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sbWeight = (SeekBar) findViewById(R.id.sbWeight);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        lParams1 = (LinearLayout.LayoutParams) btn1.getLayoutParams();
        lParams2 = (LinearLayout.LayoutParams) btn2.getLayoutParams();

        sbWeight.setOnSeekBarChangeListener(this);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
        int leftValue = progress;
        int rightValue = seekBar.getMax() - progress;
        lParams1.weight = leftValue;
        lParams2.weight = rightValue;
        /*
        если бы не было setText то нужно было бы вызывать
        btn1.requestLayout() для его перерисовки, атак он вызывается в setText()
        */
        btn1.setText(String.valueOf(leftValue));
        btn2.setText(String.valueOf(rightValue));
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
