package com.example.tugas_sqllite;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tugas_sqllite.R;

public class InputData extends AppCompatActivity implements View.OnClickListener {

    EditText editnom,editname,date,editgender,editalamat;
    Button btnSubmit;
    Context context;
    String aksi,nomor;
    Siswa updaete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.input_data);
        context =this;

        editnom = findViewById(R.id.edtnmr);
        editname = findViewById(R.id.edtnama);
        date = findViewById(R.id.edttgllahir);
        editgender  = findViewById(R.id.edtjenkel);
        editalamat = findViewById(R.id.edtalamat);
        btnSubmit = findViewById(R.id.btnKirim);

        aksi  = getIntent().getStringExtra("UPDATE_ACTION");
        updaete = getIntent().getParcelableExtra("UPDATE_INTENT");

        if (aksi==null){
            aksi="Submit";
        }else {
            nomor=String.valueOf(updaete.getNoSiswa());
        }

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseHelper db = new DatabaseHelper(context);
                Siswa siswa = new Siswa();
                String btnState = btnSubmit.getText().toString();

                if (btnState.equals("Simpan")){
                    siswa.setNoSiswa(Integer.parseInt(editnom.getText().toString()));
                    siswa.setNama(editname.getText().toString());
                    siswa.setJenisKelamin(editgender.getText().toString());
                    siswa.setDate(date.getText().toString());
                    siswa.setAlamat(editalamat.getText().toString());
                    db.insert(siswa);
                    startActivity(new Intent(context,LihatData.class));

                }else{
                    siswa.setNoSiswa(Integer.parseInt(editnom.getText().toString()));
                    siswa.setNama(editname.getText().toString());
                    siswa.setJenisKelamin(editgender.getText().toString());
                    siswa.setDate(date.getText().toString());
                    siswa.setAlamat(editalamat.getText().toString());
                    db.update(siswa);

                }
            }
        });
    }


    @Override
    public void onClick(View view) {


    }
}

