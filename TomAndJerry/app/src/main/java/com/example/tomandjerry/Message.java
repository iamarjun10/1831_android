package com.example.tomandjerry;

import java.io.Serializable;

public class Message implements Serializable {
    String message;
    String user;

    public Message(String message, String user){
        this.message = message;
        this.user = user;
    }
}
