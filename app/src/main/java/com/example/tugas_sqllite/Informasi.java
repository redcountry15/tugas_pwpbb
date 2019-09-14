package com.example.tugas_sqllite;

import android.os.Bundle;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Informasi extends AppCompatActivity {
    EditText edtnomor,edtnama,edttanggal,edtjenkel,edtalamat;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.informasi_profile);

        edtnomor =findViewById(R.id.editDetailNoSiswa);
        edtnama =findViewById(R.id.editDetailNamaSiswa);
        edttanggal = findViewById(R.id.edttgllahir);
        edtjenkel =findViewById(R.id.editDetailJK);
        edtalamat = findViewById(R.id.editDetailAlamat);

        Siswa siswa = getIntent().getParcelableExtra("DETAIL_INTENT");

        edtnomor.setText(String.valueOf(siswa.getNoSiswa()));
        edtnama.setText(siswa.getNama());
        edttanggal.setText(siswa.getDate());
        edtjenkel.setText(siswa.getJenisKelamin());
        edtalamat.setText(siswa.getAlamat());


    }
}
