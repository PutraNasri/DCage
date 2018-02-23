package com.example.user.dcage.presenter;

import android.app.Activity;
import android.widget.Toast;

import com.example.user.dcage.model.Proses.DaftarunitTask;
import com.example.user.dcage.model.Unit;
import com.example.user.dcage.view.ListunitView;

import java.util.ArrayList;

/**
 * Created by user on 1/29/2018.
 */

public class DaftarunitPresenterImpl implements DaftarunitPresenter {

    private ListunitView listunit;
    private Activity activity;

    public DaftarunitPresenterImpl(ListunitView listunit, Activity activity) {
        this.listunit = listunit;
        this.activity = activity;
    }

    @Override
    public void kirimHasil(ArrayList<Unit> hasil) {
        listunit.tampilkanHasil(hasil);
 //       Toast.makeText(activity, ""+hasil.size(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void ambil_data(String id) {
        new DaftarunitTask(this, activity).execute(id);
    }
}
