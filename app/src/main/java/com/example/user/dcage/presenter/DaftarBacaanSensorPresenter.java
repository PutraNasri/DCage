package com.example.user.dcage.presenter;

import com.example.user.dcage.model.Unit;

import java.util.ArrayList;

public interface DaftarBacaanSensorPresenter {
    void ambil_data(String id);
    void kirimHasil(ArrayList<Unit> hasil);
}
