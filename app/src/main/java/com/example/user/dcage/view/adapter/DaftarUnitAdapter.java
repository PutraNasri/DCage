package com.example.user.dcage.view.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


import com.example.user.dcage.R;
import com.example.user.dcage.model.Unit;

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


    }

    @Override
    public int getItemCount() {
        return daftarUnit.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.txt_nama)TextView txtNama;
        @BindView(R.id.txt_keterangan)TextView txtKeterangan;
        public ViewHolder(View itemView) {
            super(itemView);
//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Log.d("RecyclerView", "onClick：" + getPosition());
//                }
//            });
            ButterKnife.bind(this, itemView);

        }
    }
}
