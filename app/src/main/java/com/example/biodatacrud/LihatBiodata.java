package com.example.biodatacrud;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LihatBiodata extends AppCompatActivity {
    protected Cursor cursor;
    DataHelper dbHelper;
    Button bt2;
    TextView tv1,tv2,tv3,tv4,tv5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_biodata);
        dbHelper = new DataHelper(this);
        tv1 = findViewById(R.id.tvnomor);
        tv2 = findViewById(R.id.tvnama);
        tv3 = findViewById(R.id.tvtgl);
        tv4 = findViewById(R.id.tvgender);
        tv5 = findViewById(R.id.tvalamat);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM biodata WHERE nama = '" +
                getIntent().getStringExtra("nama") + "'", null);
        cursor.moveToFirst();
        if (cursor.getCount()>0)
        {
            cursor.moveToPosition(0);
            tv1.setText(cursor.getString(0).toString());
            tv2.setText(cursor.getString(1).toString());
            tv3.setText(cursor.getString(2).toString());
            tv4.setText(cursor.getString(3).toString());
            tv5.setText(cursor.getString(4).toString());
        }
        bt2 = findViewById(R.id.btnkembali);
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                finish();
            }
        });
    }
}