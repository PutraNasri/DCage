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
import com.example.user.dcage.presenter.DaftarunitPresenter;
import com.example.user.dcage.presenter.DaftarunitPresenterImpl;
import com.example.user.dcage.presenter.UnitbaruPresenter;
import com.example.user.dcage.presenter.UnitbaruPresenterImpl;
import com.example.user.dcage.view.adapter.DaftarUnitAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Listunit extends AppCompatActivity implements ListunitView,UnitbaruView {


    private DaftarunitPresenter daftarunitPresenter;
    private UnitbaruPresenter unitbaruPresenter;
    @BindView(R.id.rv_daftar_unit)RecyclerView rvDaftarUnit;
    @BindView(R.id.fabTambahUnit)FloatingActionButton fabtambahunit;
    @BindView(R.id.progressBar3)ProgressBar loading3;
    String id = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listunit);
        daftarunitPresenter = new DaftarunitPresenterImpl(this, this);
        unitbaruPresenter = new UnitbaruPresenterImpl(this, this);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        id  = intent.getStringExtra("id_unit");

        daftarunitPresenter.ambil_data(id);
     //   Toast.makeText(this, ""+id, Toast.LENGTH_SHORT).show();
    }


    @Override
    public void tampilkanHasil(ArrayList<Unit> hasil) {
        LinearLayoutManager manager = new LinearLayoutManager(this);
        rvDaftarUnit.setLayoutManager(manager);
        rvDaftarUnit.setAdapter(new DaftarUnitAdapter(this, hasil));
    }
    @Override
    public void tampilkanHasil(String hasil) {
        Toast.makeText(this, ""+hasil, Toast.LENGTH_SHORT).show();
        loading3.setVisibility(View.INVISIBLE);

    }

    @OnClick(R.id.fabTambahUnit)
    public void setFabtambahunit(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);


        final ArrayList<String> tambah_unit = new ArrayList<>();

        View view = LayoutInflater.from(this).inflate(R.layout.form_tambah_unit, null, false);
        builder.setView(view);

        EditText namakandang = (EditText) view.findViewById(R.id.edt_namaaktuator);
        EditText keterangankandang = (EditText) view.findViewById(R.id.edt_keteranganunit);

        Button tambah = (Button) view.findViewById(R.id.btn_tambah_unit);

        Dialog dialog = builder.create();
        dialog.show();

        tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                unitbaruPresenter.tambahunit(id, namakandang.getText().toString(),keterangankandang.getText().toString());
                loading3.setVisibility(View.VISIBLE);
                daftarunitPresenter.ambil_data(id);
                dialog.dismiss();
            }
        });

    }


}
