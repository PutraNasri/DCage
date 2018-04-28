package com.example.user.dcage.presenter;

import android.app.Activity;

import com.example.user.dcage.model.Proses.UnitbaruTask;
import com.example.user.dcage.view.Listunit;
import com.example.user.dcage.view.UnitbaruView;

/**
 * Created by user on 1/24/2018.
 */

public class UnitbaruPresenterImpl implements  UnitbaruPresenter{
    private Activity activity ;
    private Listunit view ;

    public UnitbaruPresenterImpl(Listunit view,Activity activity) {
        this.view=view;
        this.activity=activity;
    }

    @Override
    public void tambahunit(String id, String s, String s1) {
        new UnitbaruTask(this,activity).execute(id, s,s1);
    }

    @Override
    public void kirimhasil(String hasil) {
        view.tampilkanHasil(hasil);

    }
}
