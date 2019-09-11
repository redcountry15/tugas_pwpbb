package com.example.tugas_sqllite;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class LihatData extends AppCompatActivity implements View.OnClickListener {
    Button btnTambah;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_data);


        btnTambah = (Button) findViewById(R.id.btntambah);

        btnTambah.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btntambah:
                Intent input = new Intent(LihatData.this, InputData.class);
                startActivity(input);
                break;
            default:
                break;
        }
    }
}
