package com.example.user.dcage.view;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.example.user.dcage.R;
import com.example.user.dcage.model.Unit;
import com.example.user.dcage.presenter.DaftarSensorPresenter;
import com.example.user.dcage.presenter.DaftarSensorPresenterImpl;
import com.example.user.dcage.view.adapter.DaftarSensorAdapter;
import java.util.ArrayList;
import butterknife.BindView;
import butterknife.ButterKnife;

public class Listsensor extends AppCompatActivity implements ListsensorView{
    private DaftarSensorPresenter daftarsensorPresenter;
    @BindView(R.id.rv_daftar_sensor)RecyclerView rvDaftarSensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listsensor);
        daftarsensorPresenter = new DaftarSensorPresenterImpl(this, this);
        ButterKnife.bind(this);

        String id = "5738600293466112";  // id kandang
        daftarsensorPresenter.ambil_data(id);
    }

    @Override
    public void tampilkanHasil(ArrayList<Unit> hasil) {
        LinearLayoutManager manager = new LinearLayoutManager(this);
        rvDaftarSensor.setLayoutManager(manager);
        rvDaftarSensor.setAdapter(new DaftarSensorAdapter(this, hasil));
    }
}
