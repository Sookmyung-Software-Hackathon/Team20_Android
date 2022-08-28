package com.example.team20.domain;


public class Registration { //등록된 물건 전부 다
    private int itemId;

    private String itemName;

    private byte[] itemImage = new byte[]{};


    private String memberId;
    private Long itemPrice;

    private String memo;

    private String category;


    public Registration(String itemName, byte[] itemImage, String memo, String memberId, String category, Long itemPrice) {
        this.itemName = itemName;
        this.itemImage = itemImage;
        this.memo = memo;
        this.memberId = memberId;
        this.category = category;
        this.itemPrice = itemPrice;
    }

    public byte[] getItemImage() {
        return itemImage;
    }

    public void setItemImage(byte[] itemImage) {
        this.itemImage = itemImage;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }


    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public Long getItemPrice() {
        return itemPrice;
    }


    public void setItemPrice(Long itemPrice) {

        this.itemPrice = itemPrice;
    }

    public String getMemo() { return memo;
    }

    public void setMemo(String memo) { this.memo = memo;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
}
