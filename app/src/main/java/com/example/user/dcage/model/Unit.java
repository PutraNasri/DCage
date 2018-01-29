package com.example.user.dcage.model;

import java.io.Serializable;

/**
 * Created by user on 1/24/2018.
 */

public class Unit implements Serializable {
    private String id ;
    private String keterangan ;
    private String nama ;

    public Unit() {
    }

    public Unit(String id, String keterangan, String nama) {
        this.id = id;
        this.keterangan = keterangan;
        this.nama = nama;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
}
