package com.example.alertdialogexercise;

public class EmergencyContact {

    String name;
    int imgResourceId;
    String phoneNumber;

    public EmergencyContact(String name, int imgResourceId, String phoneNumber) {
        this.name = name;
        this.imgResourceId = imgResourceId;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImgResourceId() {
        return imgResourceId;
    }

    public void setImgResourceId(int imgResourceId) {
        this.imgResourceId = imgResourceId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
