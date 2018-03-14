package com.example.user.dcage.presenter;

import android.app.Activity;
import android.hardware.Sensor;

import com.example.user.dcage.model.Proses.DaftarsensorTask;
import com.example.user.dcage.model.Unit;
import com.example.user.dcage.view.ListsensorView;
import java.util.ArrayList;

/**
 * Created by user on 3/14/2018.
 */

public class DaftarSensorPresenterImpl implements  DaftarSensorPresenter {
    private ListsensorView listsensor;
    private Activity activity;

    public DaftarSensorPresenterImpl(ListsensorView listsensor, Activity activity) {
        this.listsensor = listsensor;
        this.activity = activity;
    }

    @Override
    public void ambil_data(String id) {

            new DaftarsensorTask(this, activity).execute(id);

    }

    @Override
    public void kirimHasil(ArrayList<Unit> hasil) {
        listsensor.tampilkanHasil(hasil);
    }
}
