package ru.startandroid.p0331sharedpreferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText etText;
    Button btnSave, btnLoad;

    SharedPreferences sharedPreferences;

    final String SAVED_TEXT = "saved_text";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etText = (EditText) findViewById(R.id.etText);
        btnLoad = (Button) findViewById(R.id.btnLoad);
        btnSave = (Button) findViewById(R.id.btnSave);
        btnLoad.setOnClickListener(this);
        btnSave.setOnClickListener(this);

        loadText();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        saveText(SAVED_TEXT);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnLoad:
                loadText();
                break;
            case R.id.btnSave:
                saveText(SAVED_TEXT);
                break;
            default:
                break;
        }
    }

    private void saveText(String text) {
        sharedPreferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(SAVED_TEXT, etText.getText().toString());
        editor.apply();
        Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show();
    }

    private void loadText() {
        sharedPreferences = getPreferences(MODE_PRIVATE);
        String savedText = sharedPreferences.getString(SAVED_TEXT, "");
        etText.setText(savedText);
        Toast.makeText(this, "Text loaded", Toast.LENGTH_SHORT).show();
    }
}
