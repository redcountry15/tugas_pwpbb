package com.example.tugas_sqllite;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnLihat,btnInput,btnInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);



        btnLihat = (Button)findViewById(R.id.btn_lihat);
        btnInput = (Button)findViewById(R.id.btn_input);
        btnInfo = (Button)findViewById(R.id.btn_info);

        btnLihat.setOnClickListener(this);
        btnInput.setOnClickListener(this);
        btnInfo.setOnClickListener(this);

    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.btn_lihat:
                Intent lihat = new Intent(HomeActivity.this,LihatData.class);
                startActivity(lihat);
                break;

            case R.id.btn_input:
                Intent input = new Intent(HomeActivity.this,InputData.class);
                startActivity(input);
                break;

            case R.id.btn_info:
                Intent informasi = new Intent(HomeActivity.this,Biodata.class);
                startActivity(informasi);
                break;
            default:
                break;
        }
    }
}
