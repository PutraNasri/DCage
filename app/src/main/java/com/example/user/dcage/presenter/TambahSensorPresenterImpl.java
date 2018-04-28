package com.example.user.dcage.presenter;

import android.app.Activity;

import com.example.user.dcage.model.Proses.SensorbaruTask;
import com.example.user.dcage.model.Proses.UnitbaruTask;
import com.example.user.dcage.view.Listsensor;
import com.example.user.dcage.view.ListsensorView;
import com.example.user.dcage.view.TambahSensorView;

/**
 * Created by user on 2/23/2018.
 */

public class TambahSensorPresenterImpl implements TambahSensorPresenter {

    private Listsensor listsensor;
    private Activity activity;

    public TambahSensorPresenterImpl(Listsensor listsensor, Activity activity) {
        this.listsensor = listsensor;
        this.activity = activity;
    }

    @Override
    public void tambahsensor(String id, String s, String s1) {

        new SensorbaruTask(this,activity).execute(id, s,s1);
    }

    @Override
    public void kirimhasil(String hasil) {
        listsensor.tampilkanHasil(hasil);
    }
}
