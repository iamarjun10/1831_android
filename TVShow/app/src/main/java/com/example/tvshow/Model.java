package com.example.tvshow;

public class Model {

    String name;
    String nickName;
    String img;
    String realName;

    public Model(){

    }

    public Model(String name, String nickName, String img, String realName) {
        this.name = name;
        this.nickName = nickName;
        this.img = img;
        this.realName = realName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

}
