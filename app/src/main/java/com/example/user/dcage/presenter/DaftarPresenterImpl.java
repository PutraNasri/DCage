package com.example.user.dcage.presenter;

import android.app.Activity;
import android.widget.Toast;

import com.example.user.dcage.Proses.DaftarTask;
import com.example.user.dcage.Proses.LoginTask;
import com.example.user.dcage.view.RegisterView;

/**
 * Created by user on 12/27/2017.
 */

public class DaftarPresenterImpl implements DaftarPresenter {
    private RegisterView view;
    private Activity activity;

    public DaftarPresenterImpl(RegisterView view, Activity activity) {
        this.view = view;
        this.activity = activity;
    }

    @Override
    public void mendaftar(String nama, String alamat, String email, String password) {
        new DaftarTask(this, activity).execute(nama, alamat, email, password);
      //  Toast.makeText(activity, ""+nama+alamat+email+password, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void kirimhasil(String hasil) {
        view.tampilkanHasil(hasil);

    }
}
