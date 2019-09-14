package com.example.tugas_sqllite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class InfoSiswa extends AppCompatActivity {
    EditText edtnomor,edtnama,edttanggal,edtjenkel,edtalamat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_siswa);
        edtnomor =findViewById(R.id.editDetailNoSiswa);
        edtnama =findViewById(R.id.editDetailNamaSiswa);
        edttanggal = findViewById(R.id.editDetailTanggalLahir);
        edtjenkel =findViewById(R.id.editDetailJK);
        edtalamat = findViewById(R.id.editDetailAlamat);
        edttanggal.setFocusable(false);

        edtnomor.setFocusable(false);
        edtnama.setFocusable(false);
        edtjenkel.setFocusable(false);
        edtalamat.setFocusable(false);

        Siswa siswa = getIntent().getParcelableExtra("DETAIL_INTENT");

        edtnomor.setText(String.valueOf(siswa.getNoSiswa()));
        edtnama.setText(siswa.getNama());
        edtjenkel.setText(siswa.getJenisKelamin());
        edttanggal.setText(siswa.getDate());
        edtalamat.setText(siswa.getAlamat());
    }
}
