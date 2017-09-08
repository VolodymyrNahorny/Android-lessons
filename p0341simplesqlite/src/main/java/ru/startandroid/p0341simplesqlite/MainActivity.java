package ru.startandroid.p0341simplesqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    final String LOG_TAG = "myLogTag";

    Button btnAdd, btnRead, btnClear, btnUpdate, btnDelete;
    EditText etName, etEmail, etID;

    DBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = (EditText) findViewById(R.id.etName);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etID = (EditText) findViewById(R.id.etID);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnRead = (Button) findViewById(R.id.btnRead);
        btnClear = (Button) findViewById(R.id.btnClear);
        btnUpdate = (Button) findViewById(R.id.btnUpd);
        btnDelete = (Button) findViewById(R.id.btnDel);
        btnAdd.setOnClickListener(this);
        btnRead.setOnClickListener(this);
        btnClear.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
        btnUpdate.setOnClickListener(this);

        dbHelper = new DBHelper(this);
    }

    @Override
    public void onClick(View view) {
        ContentValues contentValues = new ContentValues();
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        String name = etName.getText().toString();
        String email = etEmail.getText().toString();
        String id = etID.getText().toString();

        switch (view.getId()) {
            case R.id.btnAdd:
                Log.d(LOG_TAG, "--- Insert into my_table ---");
                contentValues.put("name", name);
                contentValues.put("email", email);

                long rowId = db.insert("my_table", null, contentValues);
                Log.d(LOG_TAG, "--- Values successfully inserted!  row_id = " + rowId + "---");
                break;
            case R.id.btnRead:
                Log.d(LOG_TAG, "--- Select from my_table ---");
                Cursor cursor = db.query("my_table", null, "id = ?", new String[]{id}, null, null, null);

                if (cursor.moveToFirst()) {
                    int idColIndex = cursor.getColumnIndex("id");
                    int nameColIndex = cursor.getColumnIndex("name");
                    int emailColIndex = cursor.getColumnIndex("email");

                    do {
                        etName.setText(cursor.getString(nameColIndex));
                        etEmail.setText(cursor.getString(emailColIndex));
                        Log.d(LOG_TAG,
                            "id: " + cursor.getInt(idColIndex) + etID.getText().toString() +
                            ", name: " + cursor.getString(nameColIndex) + etName.getText().toString() +
                            ", email: " + cursor.getString(emailColIndex) + etEmail.getText().toString());
                    } while (cursor.moveToNext());
                } else {
                    Log.d(LOG_TAG, "my_table is empty");
                    cursor.close();
                }
                break;
            case R.id.btnClear:
                Log.d(LOG_TAG, "--- Truncate my_table ---");
                int rowsAffected = db.delete("my_table", null, null);
                Log.d(LOG_TAG, "--- my_table truncated! rowsAffected = " + rowsAffected);
                break;
            case R.id.btnUpd:
                if (id.equalsIgnoreCase("")) break;
                Log.d(LOG_TAG, "--- Delete row by id from my_table ---");

                contentValues.put("name", name);
                contentValues.put("email", email);
                int rowsUpdated = db.update("my_table", contentValues, "id = ?", new String[]{id});
                Log.d(LOG_TAG, "--- my_table row(s) updated, count = " + rowsUpdated);
                break;
            case R.id.btnDel:
                if (id.equalsIgnoreCase("")) break;
                Log.d(LOG_TAG, "--- Update row by id in my_table");
                int rowsDeleted = db.delete("my_table", "id = ?", new String[]{id});
                Log.d(LOG_TAG, "--- my_table row(s) deleted, count = " + rowsDeleted);
                break;
        }
        dbHelper.close();
    }

    class DBHelper extends SQLiteOpenHelper{

        DBHelper(Context context) {
            super(context, "myDB", null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            Log.d(LOG_TAG, "--- onCreate database ---");
            sqLiteDatabase.execSQL("CREATE TABLE my_table (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "name TEXT," +
                    "email TEXT" + ");");
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        }
    }
}
