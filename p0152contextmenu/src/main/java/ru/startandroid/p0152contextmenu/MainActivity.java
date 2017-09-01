package ru.startandroid.p0152contextmenu;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    TextView textView, tv2;
    Boolean isTextView = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.text);
        tv2 = (TextView) findViewById(R.id.tv2);

        textView.setOnCreateContextMenuListener(this);
        tv2.setOnCreateContextMenuListener(this);
        registerForContextMenu(textView);
        registerForContextMenu(tv2);
        textView.setOnClickListener(this);
        tv2.setOnClickListener(this);
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        switch (v.getId()){
            case R.id.text:
                getMenuInflater().inflate(R.menu.mycontextmenu1, menu);
                break;
            case R.id.tv2:
                getMenuInflater().inflate(R.menu.mycontextmenu2, menu);
                break;
        }
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        Log.d("TAG", "onprepare");
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        Log.d("TAG", "lalal");
        switch (item.getItemId()) {
            case R.id.cb:
                textView.setTextColor(Color.BLUE);
                textView.setText("Blue");
                break;
            case R.id.cr:
                textView.setTextColor(Color.RED);
                textView.setText("Red");
                break;
            case R.id.cg:
                textView.setTextColor(Color.GREEN);
                textView.setText("Green");
                break;
            case R.id.s22:
                textView.setTextSize(22);
                break;
            case R.id.s26:
                textView.setTextSize(26);
                break;
            case R.id.s30:
                textView.setTextSize(30);
                break;
            case R.id.cb1:
                tv2.setTextColor(Color.BLUE);
                tv2.setText("Blue");
                break;
            case R.id.cr1:
                tv2.setTextColor(Color.RED);
                tv2.setText("Red");
                break;
            case R.id.cg1:
                tv2.setTextColor(Color.GREEN);
                tv2.setText("Green");
                break;
            case R.id.s221:
                tv2.setTextSize(22);
                break;
            case R.id.s261:
                tv2.setTextSize(26);
                break;
            case R.id.s301:
                tv2.setTextSize(30);
                break;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv2:
                textView.setText(" TV 2 ");
                break;
            case R.id.text:
                textView.setText(" TextVIEW");
                break;
        }
    }
}
