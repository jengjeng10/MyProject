package com.itgroup.bean;

public class Character {

    private int char_id ;
    private String user_id ;
    private String char_name ;
    private String char_class ;
    private int char_level ;
    private int hp ;
    private int mp ;
    private String created_at ;

    public Character(){


    }

    public int getChar_id() {
        return char_id;
    }

    public void setChar_id(int char_id) {
        this.char_id = char_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getChar_name() {
        return char_name;
    }

    public void setChar_name(String char_name) {
        this.char_name = char_name;
    }

    public String getChar_class() {
        return char_class;
    }

    public void setChar_class(String char_class) {
        this.char_class = char_class;
    }

    public int getChar_level() {
        return char_level;
    }

    public void setChar_level(int char_level) {
        this.char_level = char_level;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    @Override
    public String toString() {
        return "CharacterBean{" +
                "char_id=" + char_id +
                ", user_id='" + user_id + '\'' +
                ", char_name='" + char_name + '\'' +
                ", char_class='" + char_class + '\'' +
                ", char_level=" + char_level +
                ", hp=" + hp +
                ", mp=" + mp +
                ", created_at='" + created_at + '\'' +
                '}';
    }
}
