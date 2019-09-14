package com.example.tugas_sqllite;

import android.os.Parcel;
import android.os.Parcelable;

public class Siswa implements Parcelable {


    int noSiswa;
    String nama;
    String date;
    String jenisKelamin;
    String Alamat;

    protected Siswa(Parcel in) {
        noSiswa = in.readInt();
        nama = in.readString();
        date = in.readString();
        jenisKelamin = in.readString();
        Alamat = in.readString();
    }

    public Siswa() {

    }

    public int getNoSiswa() {
        return noSiswa;
    }

    public void setNoSiswa(int noSiswa) {
        this.noSiswa = noSiswa;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getAlamat() {
        return Alamat;
    }

    public void setAlamat(String alamat) {
        Alamat = alamat;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.noSiswa);
        parcel.writeString(this.nama);
        parcel.writeString(this.date);
        parcel.writeString(this.jenisKelamin);
        parcel.writeString(this.Alamat);

    }
    public static final Creator<Siswa> CREATOR = new Creator<Siswa>() {
        @Override
        public Siswa createFromParcel(Parcel in) {
            return new Siswa(in);
        }

        @Override
        public Siswa[] newArray(int size) {
            return new Siswa[size];
        }
    };

}

