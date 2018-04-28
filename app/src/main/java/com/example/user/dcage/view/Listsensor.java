package com.example.user.dcage.view;


import android.app.Dialog;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.user.dcage.R;
import com.example.user.dcage.model.Unit;
import com.example.user.dcage.presenter.DaftarSensorPresenter;
import com.example.user.dcage.presenter.DaftarSensorPresenterImpl;
import com.example.user.dcage.presenter.TambahSensorPresenter;
import com.example.user.dcage.presenter.TambahSensorPresenterImpl;
import com.example.user.dcage.view.adapter.DaftarSensorAdapter;
import java.util.ArrayList;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Listsensor extends AppCompatActivity implements ListsensorView, TambahSensorView{
    private DaftarSensorPresenter daftarsensorPresenter;
    private TambahSensorPresenter tambahsensorPresenter;
    @BindView(R.id.rv_daftar_sensor)RecyclerView rvDaftarSensor;
    @BindView(R.id.progressBar3)ProgressBar loading3;
    @BindView(R.id.fabTambahSensor)FloatingActionButton fabtambahsensor;
    String id = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listsensor);
        daftarsensorPresenter = new DaftarSensorPresenterImpl(this, this);
        tambahsensorPresenter = new TambahSensorPresenterImpl(this, this);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        id  = intent.getStringExtra("id_unit");

        daftarsensorPresenter.ambil_data(id);
    }

    @Override
    public void tampilkanHasil(ArrayList<Unit> hasil) {
        LinearLayoutManager manager = new LinearLayoutManager(this);
        rvDaftarSensor.setLayoutManager(manager);
        rvDaftarSensor.setAdapter(new DaftarSensorAdapter(this, hasil));
    }

    @Override
    public void tampilkanHasil(String hasil) {
        Toast.makeText(this, ""+hasil, Toast.LENGTH_SHORT).show();
        loading3.setVisibility(View.INVISIBLE);

    }

    @OnClick(R.id.fabTambahSensor)
    public void setFabtambahsensor(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        final ArrayList<String> tambah_unit = new ArrayList<>();

        View view = LayoutInflater.from(this).inflate(R.layout.form_tambah_sensor, null, false);
        builder.setView(view);

        EditText namasensor = (EditText) view.findViewById(R.id.edt_namaaktuator);
        EditText keterangansensor = (EditText) view.findViewById(R.id.edt_keterangansensor);

        Button tambah = (Button) view.findViewById(R.id.btn_tambah_sensor);

        Dialog dialog = builder.create();
        dialog.show();

        tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tambahsensorPresenter.tambahsensor(id, namasensor.getText().toString(),keterangansensor.getText().toString());
                loading3.setVisibility(View.VISIBLE);
                daftarsensorPresenter.ambil_data(id);
                dialog.dismiss();


            }
        });

    }
}
