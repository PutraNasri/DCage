package com.example.user.dcage.model;

import java.io.Serializable;

public class BacaanSensor implements Serializable {

    private  String id ;
    private  String nilai ;
    private  String timestamp ;
    private  String baterai ;

    public BacaanSensor() {
    }

    public BacaanSensor(String id, String nilai, String timestamp, String baterai) {
        this.id = id;
        this.nilai = nilai;
        this.timestamp = timestamp;
        this.baterai = baterai;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNilai() {
        return nilai;
    }

    public void setNilai(String nilai) {
        this.nilai = nilai;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getBaterai() {
        return baterai;
    }

    public void setBaterai(String baterai) {
        this.baterai = baterai;
    }
}
