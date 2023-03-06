package com.example.abiturients;

import javafx.beans.property.SimpleIntegerProperty;

import java.util.Date;

public class tablemoder {
    int id;
    String login;
    String password;
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public tablemoder(int id, String login, String password){
        this.id = id;
        this.login = login;
        this.password = password;
    }
    public String getLogin(){
        return login;
    }
    public void setLogin(String login){
        this.login = login;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }
}
