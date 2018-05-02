package com.example.user.dcage.model.Proses;

import android.app.Activity;
import android.os.AsyncTask;

import com.example.user.dcage.presenter.DaftarAktuatorPresenterImpl;
import com.example.user.dcage.presenter.DaftarBacaanSensorPresenter;
import com.example.user.dcage.presenter.DaftarBacaanSensorPresenterImpl;

public class BacaanSensorTask extends AsyncTask<String, Void, String> {
    private DaftarBacaanSensorPresenter daftarAktuatorPresenter;
    private String id;

    private byte[] outputBytes;
    private StringBuilder response = new StringBuilder();
    private Activity activity;

    public BacaanSensorTask(DaftarBacaanSensorPresenter daftarAktuatorPresenter, Activity activity) {
        this.daftarAktuatorPresenter = daftarAktuatorPresenter;
        this.activity = activity;
    }

    @Override
    protected String doInBackground(String... strings) {
        return null;
    }
}
