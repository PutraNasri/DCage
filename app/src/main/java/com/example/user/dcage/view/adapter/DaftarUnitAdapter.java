package com.example.user.dcage.view.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.user.dcage.R;
import com.example.user.dcage.model.Unit;
import com.example.user.dcage.view.Listaktuator;
import com.example.user.dcage.view.Listsensor;
import com.example.user.dcage.view.Listunit;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by user on 2/1/2018.
 */

public class DaftarUnitAdapter extends RecyclerView.Adapter<DaftarUnitAdapter.ViewHolder> {

    private Activity activity;
    private ArrayList<Unit> daftarUnit;


    public DaftarUnitAdapter(Activity activity, ArrayList<Unit> daftarUnit) {
        this.activity = activity;
        this.daftarUnit = daftarUnit;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(activity).inflate(R.layout.adapter_unit, parent, false));

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Unit unit = daftarUnit.get(position);
        holder.txtNama.setText(unit.getNama());
        holder.txtKeterangan.setText(unit.getKeterangan());


        holder.unitcliksensor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "sensor "+unit.getId(), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent (v.getContext(), Listsensor.class);
                intent.putExtra("id_unit",unit.getId());
                activity.startActivity(intent);

            }
        });
        holder.unitclikaktuator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "aktuator "+unit.getId(), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent (v.getContext(), Listaktuator.class);
                intent.putExtra("id_unit",unit.getId());
                activity.startActivity(intent);

            }
        });
        holder.unitclikedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "edit "+unit.getId(), Toast.LENGTH_SHORT).show();

            }
        });
        holder.unitclikhapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "hapus "+unit.getId(), Toast.LENGTH_SHORT).show();

            }
        });

    }

    @Override
    public int getItemCount() {
        return daftarUnit.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.txt_nama)TextView txtNama;
        @BindView(R.id.txt_keterangan)TextView txtKeterangan;
        @BindView(R.id.cv_unit_sensor)Button unitcliksensor;
        @BindView(R.id.cv_unit_aktuator)Button unitclikaktuator;
        @BindView(R.id.cv_unit_edit)ImageView unitclikedit;
        @BindView(R.id.cv_unit_hapus)ImageView unitclikhapus;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }
}
