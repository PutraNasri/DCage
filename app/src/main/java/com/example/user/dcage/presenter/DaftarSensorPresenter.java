package com.example.user.dcage.presenter;

import android.hardware.Sensor;

import com.example.user.dcage.model.Unit;

import java.util.ArrayList;

/**
 * Created by user on 3/14/2018.
 */

public interface DaftarSensorPresenter {
    void ambil_data(String id);

    void kirimHasil(ArrayList<Unit> hasil);
}
