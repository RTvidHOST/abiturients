package com.example.abiturients;

public class Moder {
    private String id;
    private String login;
    private String password;
    public Moder(String id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
    }
    public Moder() {
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}