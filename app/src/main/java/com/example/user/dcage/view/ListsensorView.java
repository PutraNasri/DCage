package com.example.user.dcage.view;

import android.hardware.Sensor;

import com.example.user.dcage.model.Unit;

import java.util.ArrayList;

/**
 * Created by user on 3/14/2018.
 */

public interface ListsensorView {

    void tampilkanHasil(ArrayList<Unit> hasil);

    void tampilkanHasil(String hasil);
}
