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

public class BuatBiodata extends AppCompatActivity {
    protected Cursor cursor;
    DataHelper dbHelper;
    Button bt1,bt2;
    EditText et1,et2,et3,et4,et5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buat_biodata);
        et1 = findViewById(R.id.etnomor);
        et2 = findViewById(R.id.etnama);
        et3 = findViewById(R.id.ettgl);
        et4 = findViewById(R.id.etgender);
        et5 = findViewById(R.id.etalamat);

        bt1 = findViewById(R.id.btnsimpan);
        bt2 = findViewById(R.id.btnkembali);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO Auto-generated method stub
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("insert into biodata(no, nama, tgl, jk, alamat) values('" +
                        et1.getText().toString() + "','" +
                        et2.getText().toString() + "','" +
                        et3.getText().toString() + "','" +
                        et4.getText().toString() + "','" +
                        et5.getText().toString() + "')");
                Toast.makeText(BuatBiodata.this,"Berhasil", Toast.LENGTH_LONG).show();
                MainActivity.ma.RefreshList();
                finish();
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                finish();
            }
        });
    }
}