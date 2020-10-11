package com.example.screenslide;

public class Profile {
    String name;
    String phone;
    String email;
    String password;
    String confirm_pass;

    String gender;
    String state;
    String district;
    String dob;

    public Profile(){
        this.name="Virat";
        this.phone="9922443311";
        this.email="virat.18@gmail.com";
        this.password="viratkohli18";
        this.confirm_pass="viratkohli18";

        this.gender="male";
        this.state="Goa";
        this.district="North Goa";
        this.dob="23/05/1997";

    }

    public String getName(){
        return name;
    }

    public String getPhone(){
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirm_pass() {
        return confirm_pass;
    }

    public String getGender() {
        return gender;
    }

    public String getState() {
        return state;
    }

    public String getDistrict() {
        return district;
    }

    public String getDob() {
        return dob;
    }

}
