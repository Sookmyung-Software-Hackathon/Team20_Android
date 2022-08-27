package com.example.team20;

public class ReturnData {
    public String item_name;
    public String item_price;
    public byte[] item_img_path;

    public ReturnData(String item_name, String item_price, byte[] item_img_path) {
        this.item_name = item_name;
        this.item_price = item_price;
        this.item_img_path = item_img_path;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getItem_price() {
        return item_price;
    }

    public void setItem_price(String item_price) {
        this.item_price = item_price;
    }

    public byte[] getItem_img_path() {
        return item_img_path;
    }

    public void setItem_img_path(byte[] item_img_path) {
        this.item_img_path = item_img_path;
    }
}
