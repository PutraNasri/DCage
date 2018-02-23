package com.example.user.dcage.presenter;

import com.example.user.dcage.model.Unit;

import java.util.ArrayList;

/**
 * Created by user on 1/29/2018.
 */

public interface DaftarunitPresenter {
    void kirimHasil(ArrayList<Unit> hasil);

    void ambil_data(String id);

}
