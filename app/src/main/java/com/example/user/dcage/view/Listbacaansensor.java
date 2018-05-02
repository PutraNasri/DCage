
package com.example.user.dcage.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.example.user.dcage.R;
import com.example.user.dcage.model.Unit;
import com.example.user.dcage.presenter.DaftarBacaanSensorPresenter;
import com.example.user.dcage.presenter.DaftarBacaanSensorPresenterImpl;
import com.example.user.dcage.presenter.DaftarSensorPresenterImpl;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Listbacaansensor extends AppCompatActivity implements ListbacaansensorView{
    private DaftarBacaanSensorPresenter daftarBacaanSensorPresenter;
    @BindView(R.id.rv_bacaan_sensor)RecyclerView rvSensorBacaan;
    String id = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listbacaansensor);

        daftarBacaanSensorPresenter = new DaftarBacaanSensorPresenterImpl(this, this);

        ButterKnife.bind(this);

        Intent intent = getIntent();
        id  = intent.getStringExtra("id_sensor");

        daftarBacaanSensorPresenter.ambil_data(id);

    }

    @Override
    public void tampilkanHasil(ArrayList<Unit> hasil) {

    }
}
