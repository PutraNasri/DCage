package com.example.user.dcage.view.adapter;

import android.app.Activity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.dcage.R;
import com.example.user.dcage.model.Unit;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by user on 3/15/2018.
 */

public class DaftarAktuatorAdapter extends  RecyclerView.Adapter<DaftarAktuatorAdapter.ViewHolder> {
    private Activity activity;
    private ArrayList<Unit> daftarAktuator;

    public DaftarAktuatorAdapter(Activity activity, ArrayList<Unit> daftarAktuator) {
        this.activity = activity;
        this.daftarAktuator = daftarAktuator;
    }
    @Override
    public DaftarAktuatorAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new DaftarAktuatorAdapter.ViewHolder(LayoutInflater.from(activity).inflate(R.layout.adapter_aktuator, parent, false));
    }

    @Override
    public void onBindViewHolder(DaftarAktuatorAdapter.ViewHolder holder, int position) {
        Unit aktuator = daftarAktuator.get(position);
        holder.txtNama.setText(aktuator.getNama());
        holder.txtKeterangan.setText(aktuator.getKeterangan());

        holder.unitclik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, ""+aktuator.getId(), Toast.LENGTH_SHORT).show();
            }
        });
        holder.unitclikoff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, ""+aktuator.getId(), Toast.LENGTH_SHORT).show();
            }
        });
        holder.unitclikon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, ""+aktuator.getId(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return daftarAktuator.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.txt_nama)TextView txtNama;
        @BindView(R.id.txt_keterangan)TextView txtKeterangan;
        @BindView(R.id.cv_unit)CardView unitclik;
        @BindView(R.id.cv_aktuator_off)Button unitclikoff;
        @BindView(R.id.cv_aktuator_on)Button unitclikon;
        public ViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);

        }
    }
}
