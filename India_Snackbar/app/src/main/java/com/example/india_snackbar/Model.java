package com.example.india_snackbar;

public class Model {
    private String name;
    private int image;
    private String gender;

    public Model(String name,String gender,int image) {
        this.name = name;
        this.image = image;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getGender(){
        return gender;
    }

    public  void setGender(String gender){
        this.gender = gender;
    }

}
