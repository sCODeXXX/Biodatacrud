package com.example.biodatacrud;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateBiodata extends AppCompatActivity {
    protected Cursor cursor;
    DataHelper dbHelper;
    Button bt1,bt2;
    EditText et1,et2,et3,et4,et5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_biodata);
        dbHelper = new DataHelper(this);
        et1 = findViewById(R.id.etnomor);
        et2 = findViewById(R.id.etnama);
        et3 = findViewById(R.id.ettgl);
        et4 = findViewById(R.id.etgender);
        et5 = findViewById(R.id.etalamat);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM biodata WHERE nama = '" +
                getIntent().getStringExtra("nama") + "'", null);
        cursor.moveToFirst();
        if(cursor.getCount()>0){
            cursor.moveToPosition(0);
            et1.setText(cursor.getString(0).toString());
            et2.setText(cursor.getString(1).toString());
            et3.setText(cursor.getString(2).toString());
            et4.setText(cursor.getString(3).toString());
            et5.setText(cursor.getString(4).toString());
        }
        bt1 = findViewById(R.id.btnsimpan);
        bt2 = findViewById(R.id.btnkembali);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("update biodata set nama='" +
                        et2.getText().toString() +"', tgl='" +
                        et3.getText().toString() +"', jk='" +
                        et4.getText().toString() +"', alamat='" +
                        et5.getText().toString() +"' where no='" +
                        et1.getText().toString() +"'");
                Toast.makeText(UpdateBiodata.this, "Berhasil", Toast.LENGTH_LONG).show();
                MainActivity.ma.RefreshList();
                finish();
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}