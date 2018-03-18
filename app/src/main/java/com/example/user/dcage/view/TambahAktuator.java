package com.example.user.dcage.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.user.dcage.R;
import com.example.user.dcage.presenter.TambahAktuatorPresenter;
import com.example.user.dcage.presenter.TambahAktuatorPresenterImpl;
import com.example.user.dcage.presenter.TambahSensorPresenter;
import com.example.user.dcage.presenter.TambahSensorPresenterImpl;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TambahAktuator extends AppCompatActivity implements TambahAktuatorView{

    private TambahAktuatorPresenter tambahAktuatorPresenter;
    @BindView(R.id.edt_namaaktuator)EditText edtnamaaktuator;
    @BindView(R.id.edt_keteranganaktuator)EditText edtketeranganaktuator;
    @BindView(R.id.progressBar5)ProgressBar loading5;
    String id = "5738600293466112";   // id nya kandang disini

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_aktuator);
        tambahAktuatorPresenter = new TambahAktuatorPresenterImpl(this, this);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_tambahaktuator)
    public void tambah(){
        tambahAktuatorPresenter.tambahaktuator(id, edtnamaaktuator.getText().toString(),edtketeranganaktuator.getText().toString());
        loading5.setVisibility(View.VISIBLE);
    }

    @Override
    public void tampilkanHasil(String hasil) {
        Toast.makeText(this, ""+hasil, Toast.LENGTH_SHORT).show();
        loading5.setVisibility(View.INVISIBLE);
    }
}
