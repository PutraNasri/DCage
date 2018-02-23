package com.example.user.dcage.presenter;

import android.app.Activity;

import com.example.user.dcage.model.Proses.LoginTask;
import com.example.user.dcage.view.LoginView;

/**
 * Created by user on 12/27/2017.
 */

public class LoginPresenterImpl implements LoginPresenter {

    private LoginView view;
    private Activity activity;

    public LoginPresenterImpl(LoginView view, Activity activity) {
        this.view = view;
        this.activity = activity;
    }

    @Override
    public void ceklogin(String email, String password) {
        new LoginTask(this, activity).execute(email, password);

    }

    @Override
    public void kirimHasil(String hasil) {
        view.tampilkanHasil(hasil);
    }


}
