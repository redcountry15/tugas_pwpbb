package com.example.tugas_sqllite;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
    Siswa update;

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
        update = getIntent().getParcelableExtra("UPDATE_INTENT");

        if (aksi==null){
            aksi="Simpan";
        }else {
            nomor=String.valueOf(update.getNoSiswa());
        }

        if (aksi.equals("Update")){
            btnSubmit.setText("Update");
            editnom.setText(nomor);
            editnom.setFocusable(false);

            editname.setText(update.getNama());
            date.setText(update.getDate());
            editgender.setText(update.getJenisKelamin());
            editalamat.setText(update.getAlamat());

            Log.d("Updated",update.getNama());

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

                }if(btnState.equals("Update")){
                    siswa.setNoSiswa(Integer.parseInt(editnom.getText().toString()));
                    siswa.setNama(editname.getText().toString());
                    siswa.setJenisKelamin(editgender.getText().toString());
                    siswa.setDate(date.getText().toString());
                    siswa.setAlamat(editalamat.getText().toString());
                    db.update(siswa);
                    Intent pindah = new Intent(context,LihatData.class);
                    context.startActivity(pindah);

                }
            }
        });
    }


    @Override
    public void onClick(View view) {


    }
}

