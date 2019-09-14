package com.example.tugas_sqllite;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    List<Siswa> infoSiswa;
    Context context;
    onSiswaClickListener listener;

   public RecyclerViewAdapter(Context context, List<Siswa>info, onSiswaClickListener listener){
       this.context=context;
       this.infoSiswa = info;
       this.listener = listener;
   }

    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.model_recycler,parent,false);
        ViewHolder View = new ViewHolder(view);
        return View;
    }
    public  interface  onSiswaClickListener{
        void onSiswaClick(Siswa siswa);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
       final Siswa siswa = infoSiswa.get(position);
       holder.textNamaSiswa.setText(siswa.getNama());

       holder.itemView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               listener.onSiswaClick(siswa);
           }
       });
    }

    @Override
    public int getItemCount() {
        return infoSiswa.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textNamaSiswa;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textNamaSiswa = itemView.findViewById(R.id.NamaSiswa);

        }
    }
}
