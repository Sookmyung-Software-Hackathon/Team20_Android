package com.example.team20.domain;


public class CompleteRental {

    private int completeRentalId;
    private int itemId;
    private int approveRentalId;
    private String memberId;

    private byte[] completeRentalImage = new byte[]{};

    public CompleteRental(int itemId, int approveRentalId, String memberId) {

        this.itemId = itemId;
        this.approveRentalId = approveRentalId;
        this.memberId = memberId;
    }

    public byte[] getCompleteRentalImage() {
        return completeRentalImage;
    }

    public void setCompleteRentalImage(byte[] completeRentalImage) {
        this.completeRentalImage = completeRentalImage;
    }

    public int getCompleteRentalId() {
        return completeRentalId;
    }

    public void setCompleteRentalId(int completeRentalId) {
        this.completeRentalId = completeRentalId;
    }

    public int getItemId() {return itemId;}

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getApproveRentalId() {
        return approveRentalId;
    }

    public void setApproveRentalId(int approveRentalId) {
        this.approveRentalId = approveRentalId;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

}
