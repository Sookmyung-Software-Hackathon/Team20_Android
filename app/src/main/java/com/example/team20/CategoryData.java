package com.example.team20;

public class CategoryData {
    public String item_name;
    public byte[] item_img_path;

    public CategoryData(String item_name, byte[] item_img_path) {
        this.item_name = item_name;
        this.item_img_path = item_img_path;
    }
    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public byte[] getItem_img_path() {
        return item_img_path;
    }

    public void setItem_img_path(byte[] item_img_path) {
        this.item_img_path = item_img_path;
    }
}
