package com.example.abiturients;

import javafx.beans.property.SimpleIntegerProperty;

import java.util.Date;

public class tableAd {
    int id;
    String family;
    String name;
    String dad;
    Date birthday;
    String form;
    String att;
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public tableAd(int id, String family, String name, String dad, Date birthday, String form, String att){
        this.id = id;
        this.family = family;
        this.name = name;
        this.dad = dad;
        this.birthday = birthday;
        this.form = form;
        this.att = att;
    }
    public String getFamily(){
        return family;
    }
    public void setFamily(String family){
        this.family = family;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getDad(){
        return dad;
    }
    public void setDad(String dad){
        this.dad = dad;
    }
    public Date getBirthday(){
        return birthday;
    }
    public void setBirthday(Date birthday){
        this.birthday = birthday;
    }
    public String getForm(){
        return form;
    }
    public void setForm(String form){
        this.form = form;
    }
    public String getAtt(){
        return att;
    }
    public void setAtt(String att){
        this.att = att;
    }
}
