package com.example.user.dcage.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.user.dcage.R;
import com.example.user.dcage.model.Unit;
import com.example.user.dcage.presenter.DaftarunitPresenter;
import com.example.user.dcage.presenter.DaftarunitPresenterImpl;
import com.example.user.dcage.view.adapter.DaftarUnitAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Listunit extends AppCompatActivity implements ListunitView {
    private DaftarunitPresenter daftarunitPresenter;
    @BindView(R.id.rv_daftar_unit)RecyclerView rvDaftarUnit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listunit);
        daftarunitPresenter = new DaftarunitPresenterImpl(this, this);
        ButterKnife.bind(this);

        String id = "5732568548769792";
        daftarunitPresenter.ambil_data(id);
        Toast.makeText(this, "btn ok", Toast.LENGTH_SHORT).show();
    }


    @Override
    public void tampilkanHasil(ArrayList<Unit> hasil) {
        LinearLayoutManager manager = new LinearLayoutManager(this);
        rvDaftarUnit.setLayoutManager(manager);
        rvDaftarUnit.setAdapter(new DaftarUnitAdapter(this, hasil));
    }
}
