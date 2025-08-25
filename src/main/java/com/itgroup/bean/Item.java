package com.itgroup.bean;


public class Item {
    private int item_id ;
    private int char_id ;
    private String name ;
    private String type ;
    private int power ;
    private int price ;

    public Item(){

    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public int getChar_id() {
        return char_id;
    }

    public void setChar_id(int char_id) {
        this.char_id = char_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ItemBean{" +
                "item_id=" + item_id +
                ", char_id=" + char_id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", power=" + power +
                ", price=" + price +
                '}';
    }
}
