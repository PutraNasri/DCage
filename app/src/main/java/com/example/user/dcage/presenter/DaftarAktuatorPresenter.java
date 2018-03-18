package com.example.user.dcage.presenter;

import com.example.user.dcage.model.Unit;

import java.util.ArrayList;

/**
 * Created by user on 3/15/2018.
 */

public interface DaftarAktuatorPresenter {
    void ambil_data(String id);
    void kirimHasil(ArrayList<Unit> hasil);
}
