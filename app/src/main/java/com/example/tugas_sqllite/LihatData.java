package com.example.tugas_sqllite;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class LihatData extends AppCompatActivity implements RecyclerViewAdapter.onSiswaClickListener {
    Button btnTambah;
    Context context;
    CardView card1;
    RecyclerView rec;
    RecyclerView.LayoutManager layout;
    List<Siswa> infoListSiswa;



    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_data);
        context=this;



       rec = findViewById(R.id.RecyclerView);
        btnTambah =  findViewById(R.id.btnTambah);
        card1 = findViewById(R.id.CardView);
        layout = new LinearLayoutManager(context);
        rec.setLayoutManager(layout);

        setRecyclerView();


        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LihatData.this,InputData.class));
            }
        });
    }

    public void setRecyclerView(){
        DatabaseHelper db = new DatabaseHelper(this);
        infoListSiswa = db.selectedSiswa();
        RecyclerViewAdapter adapt =new RecyclerViewAdapter(this,infoListSiswa,this);

        rec.setAdapter(adapt);
        adapt.notifyDataSetChanged();
    }


    public  void onSiswaClick(final Siswa siswa){
        AlertDialog.Builder alerDialog = new AlertDialog.Builder(this);

        alerDialog.setTitle("Pilihan");
        alerDialog.setNegativeButton("Ubah", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
               Intent ubah = new Intent(context,InputData.class);
               ubah.putExtra("UPDATE_INTENT",siswa);
               ubah.putExtra("UPDATE_ACTION","Update");
               context.startActivity(ubah);

            }
        } );

        alerDialog.setNeutralButton("Detail Data", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent detail = new Intent(context,InfoSiswa.class);
                detail.putExtra("DETAIL_INTENT",siswa);
                context.startActivity(detail);
            }
        });

        alerDialog.setPositiveButton("Hapus",  new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                DatabaseHelper db = new DatabaseHelper(context);
                db.delete(siswa.getNoSiswa());
                setRecyclerView();

            }
        });
        alerDialog.show();
    }




}
