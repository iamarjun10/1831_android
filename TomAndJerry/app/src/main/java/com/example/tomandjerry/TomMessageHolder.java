package com.example.tomandjerry;

import java.util.ArrayList;

public class TomMessageHolder {
    final ArrayList<Message> chats= new ArrayList<>();

    private TomMessageHolder(){

    }

    static TomMessageHolder getInstance(){
        if( instance == null ){
            instance = new TomMessageHolder();
        }
        return instance;
    }
    private static TomMessageHolder instance;

}
