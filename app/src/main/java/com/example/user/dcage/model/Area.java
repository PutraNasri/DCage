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
    private String password ;
    private String level ;

    public Area() {
    }

    public Area(String nama, String alamat, String id, String email, String password, String level) {
        this.nama = nama;
        this.alamat = alamat;
        this.id = id;
        this.email = email;
        this.password = password;
        this.level = level;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
