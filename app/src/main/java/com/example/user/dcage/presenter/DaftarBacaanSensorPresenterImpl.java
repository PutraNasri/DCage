package com.example.user.dcage.presenter;

import android.app.Activity;

import com.example.user.dcage.model.Proses.BacaanSensorTask;
import com.example.user.dcage.model.Proses.DaftarsensorTask;
import com.example.user.dcage.model.Unit;
import com.example.user.dcage.view.Listbacaansensor;
import com.example.user.dcage.view.ListbacaansensorView;
import com.example.user.dcage.view.ListsensorView;

import java.util.ArrayList;

public class DaftarBacaanSensorPresenterImpl implements DaftarBacaanSensorPresenter {
    private ListbacaansensorView listbacaansensorView;
    private Activity activity;

    public DaftarBacaanSensorPresenterImpl(ListbacaansensorView listbacaansensorView, Activity activity) {
        this.listbacaansensorView = listbacaansensorView;
        this.activity = activity;
    }

    @Override
    public void ambil_data(String id) {
        new BacaanSensorTask(this, activity).execute(id);
    }

    @Override
    public void kirimHasil(ArrayList<Unit> hasil) {

    }
}
