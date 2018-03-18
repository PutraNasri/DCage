package com.example.user.dcage.presenter;

import android.app.Activity;

import com.example.user.dcage.model.Proses.AktuatorbaruTask;
import com.example.user.dcage.model.Proses.SensorbaruTask;
import com.example.user.dcage.view.TambahAktuator;
import com.example.user.dcage.view.TambahAktuatorView;
import com.example.user.dcage.view.TambahSensorView;

/**
 * Created by user on 3/15/2018.
 */

public class TambahAktuatorPresenterImpl implements  TambahAktuatorPresenter {
    private TambahAktuatorView tambahAktuatorView;
    private Activity activity;

    public TambahAktuatorPresenterImpl(TambahAktuatorView tambahAktuatorView, Activity activity) {
        this.tambahAktuatorView = tambahAktuatorView;
        this.activity = activity;
    }

    @Override
    public void tambahaktuator(String id, String s, String s1) {
            new AktuatorbaruTask(this,activity).execute(id, s,s1);
    }

    @Override
    public void kirimhasil(String hasil) {
        tambahAktuatorView.tampilkanHasil(hasil);
    }
}
