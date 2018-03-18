package com.example.user.dcage.presenter;

import android.app.Activity;

import com.example.user.dcage.model.Proses.DaftaraktuatorTask;
import com.example.user.dcage.model.Proses.DaftarsensorTask;
import com.example.user.dcage.model.Unit;
import com.example.user.dcage.view.Listaktuator;
import com.example.user.dcage.view.ListsensorView;

import java.util.ArrayList;

/**
 * Created by user on 3/15/2018.
 */

public class DaftarAktuatorPresenterImpl implements DaftarAktuatorPresenter {
    private Listaktuator listaktuator;
    private Activity activity;

    public DaftarAktuatorPresenterImpl(Listaktuator listaktuator, Activity activity) {
        this.listaktuator = listaktuator;
        this.activity = activity;
    }

    @Override
    public void ambil_data(String id) {
        new DaftaraktuatorTask(this, activity).execute(id);
    }

    @Override
    public void kirimHasil(ArrayList<Unit> hasil) {
        listaktuator.tampilkanHasil(hasil);

    }
}
