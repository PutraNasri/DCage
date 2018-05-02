package com.example.user.dcage.view.adapter;

import android.app.Activity;
import android.content.Intent;
import android.hardware.Sensor;
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
import com.example.user.dcage.view.Listbacaansensor;
import com.example.user.dcage.view.Listsensor;
import com.example.user.dcage.view.Listunit;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by user on 3/14/2018.
 */

public class DaftarSensorAdapter extends RecyclerView.Adapter<DaftarSensorAdapter.ViewHolder> {
    private Activity activity;
    private ArrayList<Unit> daftarSensor;

    public DaftarSensorAdapter(Activity activity, ArrayList<Unit> daftarSensor) {
        this.activity = activity;
        this.daftarSensor = daftarSensor;
    }

    @Override
    public DaftarSensorAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new DaftarSensorAdapter.ViewHolder(LayoutInflater.from(activity).inflate(R.layout.adapter_sensor, parent, false));
    }

    @Override
    public void onBindViewHolder(DaftarSensorAdapter.ViewHolder holder, int position) {
        Unit sensor = daftarSensor.get(position);
        holder.txtNama.setText(sensor.getNama());
        holder.txtKeterangan.setText(sensor.getKeterangan());

        holder.unitclik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, ""+sensor.getId(), Toast.LENGTH_SHORT).show();
            }
        });
        holder.unitclikbaca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, ""+sensor.getId(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent (v.getContext(), Listbacaansensor.class);
                intent.putExtra("id_sensor",sensor.getId());
                activity.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return daftarSensor.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.txt_nama)TextView txtNama;
        @BindView(R.id.txt_keterangan)TextView txtKeterangan;
        @BindView(R.id.cv_unit)CardView unitclik;
        @BindView(R.id.cv_sensor_baca)Button unitclikbaca;
        public ViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);

        }
    }
}
