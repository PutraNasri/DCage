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
import com.example.user.dcage.presenter.DaftarAktuatorPresenter;
import com.example.user.dcage.presenter.DaftarAktuatorPresenterImpl;
import com.example.user.dcage.presenter.TambahAktuatorPresenter;
import com.example.user.dcage.presenter.TambahAktuatorPresenterImpl;
import com.example.user.dcage.view.adapter.DaftarSensorAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Listaktuator extends AppCompatActivity implements ListaktuatorView,TambahAktuatorView {

    private DaftarAktuatorPresenter daftarAktuatorPresenter;
    private TambahAktuatorPresenter tambahAktuatorPresenter;
    @BindView(R.id.rv_daftar_aktuator)RecyclerView rvDaftarAktuator;
    @BindView(R.id.floatingtambah)FloatingActionButton fabtambahunit;
    @BindView(R.id.progressBar4)ProgressBar loading3;
    String id = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listaktuator);

        daftarAktuatorPresenter = new DaftarAktuatorPresenterImpl(this, this);
        tambahAktuatorPresenter = new TambahAktuatorPresenterImpl(this,this);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        id  = intent.getStringExtra("id_unit");

        daftarAktuatorPresenter.ambil_data(id);
    }

    @Override
    public void tampilkanHasil(ArrayList<Unit> hasil) {
        LinearLayoutManager manager = new LinearLayoutManager(this);
        rvDaftarAktuator.setLayoutManager(manager);
        rvDaftarAktuator.setAdapter(new DaftarSensorAdapter(this, hasil));
    }

    @Override
    public void tampilkanHasil(String hasil) {
        Toast.makeText(this, ""+hasil, Toast.LENGTH_SHORT).show();
        loading3.setVisibility(View.INVISIBLE);
    }

    @OnClick(R.id.floatingtambah)
    public void setFabtambahaktuator(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);


        final ArrayList<String> tambah_unit = new ArrayList<>();

        View view = LayoutInflater.from(this).inflate(R.layout.form_tambah_aktuator, null, false);
        builder.setView(view);

        EditText namaaktuator = (EditText) view.findViewById(R.id.edt_namaaktuator);
        EditText keteranganaktuator = (EditText) view.findViewById(R.id.edt_keteranganaktuator);

        Button tambah = (Button) view.findViewById(R.id.btn_tambah_aktuator);

        Dialog dialog = builder.create();
        dialog.show();

        tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tambahAktuatorPresenter.tambahaktuator(id, namaaktuator.getText().toString(),keteranganaktuator.getText().toString());
                loading3.setVisibility(View.VISIBLE);
                daftarAktuatorPresenter.ambil_data(id);
                dialog.dismiss();
            }
        });
    }
}
