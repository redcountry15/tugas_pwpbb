package com.example.tugas_sqllite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
private static final int DB_VERSION = 1;
private static final String DB_NAME = "InfoMurid";
private static final String TABLE_NAME = "t_murid";
private static final String KEY_NOMOR = "nomor_murid";
private static final String KEY_NAME  ="nama_murid";
private static final String KEY_BORN  ="tanggal_lahir";
private static final String KEY_GENDER  ="jenis_kelamin";
private static final String KEY_ADDRESS ="alamat_murid";

    public DatabaseHelper(Context context) {
        super(context, DB_NAME,null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createUserTable="Create Table "
                +TABLE_NAME+"("+KEY_NOMOR+" INTEGER PRIMARY KEY,"
                +KEY_NAME+" STRING,"+KEY_BORN+" STRING,"+KEY_GENDER+" STRING,"+KEY_ADDRESS+" STRING"+")";
          sqLiteDatabase.execSQL(createUserTable);

    }

    public List<Siswa> selectedSiswa(){
        ArrayList<Siswa> siswa = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String[] columns ={KEY_NOMOR,KEY_NAME,KEY_BORN,KEY_GENDER,KEY_ADDRESS};

        Cursor c = db.query(TABLE_NAME,columns,null,null,null,null,null);

        while (c.moveToNext()){
            int no = c.getInt(0);
            String nama= c.getString(1);
            String lahir = c.getString(2);
            String gender = c.getString(3);
            String Alamat = c.getString(4);

            Siswa inisiswa = new Siswa();
            inisiswa.setNoSiswa(no);
            inisiswa.setNama(nama);
            inisiswa.setDate(lahir);
            inisiswa.setJenisKelamin(gender);
            inisiswa.setAlamat(Alamat);

        }
        return siswa;
    }




    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
         String sql=("drop table if exists " +TABLE_NAME);
         sqLiteDatabase.execSQL(sql);
         onCreate(sqLiteDatabase);
    }

    public List<Siswa> getDataSiswa(){
        ArrayList<Siswa> siswaList = new ArrayList<>();

        SQLiteDatabase database = getReadableDatabase();
        String columns[] = {KEY_NOMOR,KEY_NAME,KEY_BORN,KEY_GENDER,KEY_ADDRESS};

        Cursor c =database.query(TABLE_NAME,columns,null,null,null,null,null);
        while (c.moveToNext()){
            int no  = c.getInt(0);
            String nama = c.getString(1);
            String born = c.getString(2);
            String gender =c.getString(3);
            String address = c.getString(4);

            Siswa siswa = new Siswa();

            siswa.setNoSiswa(no);
            siswa.setNama(nama);
            siswa.setDate(born);
            siswa.setJenisKelamin(gender);
            siswa.setAlamat(address);
        }
        return siswaList;
    }

    public void insert(Siswa siswa){
        SQLiteDatabase db =getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NOMOR,siswa.getNoSiswa());
        values.put(KEY_NAME,siswa.getNama());
        values.put(KEY_BORN,siswa.getDate());
        values.put(KEY_GENDER,siswa.getJenisKelamin());
        values.put(KEY_ADDRESS,siswa.getAlamat());
        db.insert(TABLE_NAME,null,values);
    }
    public void delete(int noSiswa ){
     SQLiteDatabase database = getWritableDatabase();
     String whereClause = KEY_NOMOR+"='"+noSiswa+"'";
     database.delete(TABLE_NAME,whereClause,null);
    }

    public  void update(Siswa siswa){
        SQLiteDatabase db =getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NOMOR,siswa.getNoSiswa());
        values.put(KEY_NAME,siswa.getNama());
        values.put(KEY_BORN,siswa.getDate());
        values.put(KEY_GENDER,siswa.getJenisKelamin());
        values.put(KEY_ADDRESS,siswa.getAlamat());
        String WhereClause = KEY_NOMOR+"='"+siswa.getNoSiswa()+"'";
        db.update(TABLE_NAME,values,WhereClause,null);

    }

}
