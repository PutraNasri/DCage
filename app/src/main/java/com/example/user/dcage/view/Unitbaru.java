package com.example.user.dcage.view;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.user.dcage.R;
import com.example.user.dcage.presenter.DaftarPresenterImpl;
import com.example.user.dcage.presenter.UnitbaruPresenter;
import com.example.user.dcage.presenter.UnitbaruPresenterImpl;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Unitbaru extends AppCompatActivity implements UnitbaruView {

    private UnitbaruPresenter unitbaruPresenter;
    @BindView(R.id.edt_namaunit)EditText edtnamaunit;
    @BindView(R.id.edt_keteranganunit)EditText edtketeranganunit;
    @BindView(R.id.progressBar3)ProgressBar loading3;
    String id = "5732568548769792";   // id nya disini

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unitbaru);
        unitbaruPresenter = new UnitbaruPresenterImpl(this, this);
        ButterKnife.bind(this);

    }
    @OnClick(R.id.btn_tambah)
    public void tambah(){
        unitbaruPresenter.tambahunit(id, edtnamaunit.getText().toString(),edtketeranganunit.getText().toString());
        loading3.setVisibility(View.VISIBLE);
    }

    @Override
    public void tampilkanHasil(String hasil) {

            Toast.makeText(this, ""+hasil, Toast.LENGTH_SHORT).show();
            loading3.setVisibility(View.INVISIBLE);
            Intent intent = new Intent(this, Login.class);
            startActivity(intent);

    }


}
