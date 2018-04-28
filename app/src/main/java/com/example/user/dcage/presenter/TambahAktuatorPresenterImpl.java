package com.example.user.dcage.presenter;

import android.app.Activity;

import com.example.user.dcage.model.Proses.AktuatorbaruTask;
import com.example.user.dcage.view.Listaktuator;

/**
 * Created by user on 3/15/2018.
 */

public class TambahAktuatorPresenterImpl implements  TambahAktuatorPresenter {
    private Listaktuator listaktuator;
    private Activity activity;

    public TambahAktuatorPresenterImpl(Listaktuator listaktuator, Activity activity) {
        this.listaktuator = listaktuator;
        this.activity = activity;
    }

    @Override
    public void tambahaktuator(String id, String s, String s1) {
            new AktuatorbaruTask(this,activity).execute(id, s,s1);
    }

    @Override
    public void kirimhasil(String hasil) {
       listaktuator.tampilkanHasil(hasil);
    }
}
