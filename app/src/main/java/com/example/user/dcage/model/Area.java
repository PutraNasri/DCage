package com.example.user.dcage.model;

import java.io.Serializable;

/**
 * Created by user on 12/27/2017.
 */

public class Area implements Serializable{
    private String nama ;
    private String alamat ;
    private String id ;
    private String email ;

    public Area(String nama, String alamat, String id, String email) {
        this.nama = nama;
        this.alamat = alamat;
        this.id = id;
        this.email = email;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Area() {
    }
}
