package com.example.user.dcage.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.user.dcage.R;
import com.example.user.dcage.presenter.TambahSensorPresenterImpl;
import com.example.user.dcage.presenter.TambahSensorPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TambahSensor extends AppCompatActivity implements TambahSensorView {

    private TambahSensorPresenter tambahSensorPresenter;
    @BindView(R.id.edt_namasensor)EditText edtnamasensor;
    @BindView(R.id.edt_keterangansensor)EditText edtketerangansensor;
    @BindView(R.id.progressBar4)ProgressBar loading4;
    String id = "5738600293466112";   // id nya kandang disini
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_sensor);
        tambahSensorPresenter = new TambahSensorPresenterImpl(this, this);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_tambahsensor)
    public void tambah(){
        tambahSensorPresenter.tambahsensor(id, edtnamasensor.getText().toString(),edtketerangansensor.getText().toString());
        loading4.setVisibility(View.VISIBLE);
    }

    @Override
    public void tampilkanHasil(String hasil) {
        Toast.makeText(this, ""+hasil, Toast.LENGTH_SHORT).show();
        loading4.setVisibility(View.INVISIBLE);
    }
}
