package com.example.team20.domain;


import java.util.ArrayList;

public class Member  { //회원정보
    private String id;
    private String name;
    private String password;
    private String email;
    private String telNum;

    private byte[] profileImage =  new byte[]{};


    private int point;

    public ArrayList<Registration> registrationArrayList = new ArrayList<>(); //내가 등록한 물건
    public ArrayList<ApproveRental> approveRentalArrayList= new ArrayList<>(); //대여중 물건
    public ArrayList<CompleteRental> completeRentalArrayList= new ArrayList<>(); //대여완료 물건


    public Member(String id, String name, byte[] profileImage, String password, String email, String telNum) {
        this.id = id;
        this.name = name;
        this.profileImage = profileImage;
        this.password = password;
        this.email = email;
        this.telNum = telNum;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id= id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(byte[] profileImage) {
        this.profileImage = profileImage;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelNum() {
        return telNum;
    }

    public void setTelNum(String telNum) {
        this.telNum = telNum;
    }


    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public ArrayList<Registration> getRegistrationArrayList() {
        return registrationArrayList;
    }

    public void setRegistrationArrayList(ArrayList<Registration> registrationArrayList) {
        this.registrationArrayList = registrationArrayList;
    }

    public ArrayList<ApproveRental> getApproveRentalArrayList() {
        return approveRentalArrayList;
    }

    public void setApproveRentalArrayList(ArrayList<ApproveRental> approveRentalArrayList) {
        this.approveRentalArrayList = approveRentalArrayList;
    }

    public ArrayList<CompleteRental> getCompleteRentalArrayList() {
        return completeRentalArrayList;
    }

    public void setCompleteRentalArrayList(ArrayList<CompleteRental> completeRentalArrayList) {
        this.completeRentalArrayList = completeRentalArrayList;
    }
}
