package ru.startandroid.p0291simpleactivityresult;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NameActivity extends AppCompatActivity implements View.OnClickListener{

    EditText editText;
    Button btnOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);

        editText = (EditText) findViewById(R.id.etName);
        btnOk = (Button) findViewById(R.id.btnOK);
        btnOk.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        intent.putExtra("name", editText.getText().toString());
        setResult(RESULT_OK, intent);
        finish();
    }
}
