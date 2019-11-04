package com.example.headphonesapplication;

public class MainModel {
    private int images;

    MainModel(){}

    public MainModel(int images){
        this.images = images;
    }

    int getImages() {
        return images;
    }

    void setImages(int images) {
        this.images = images;
    }
}
