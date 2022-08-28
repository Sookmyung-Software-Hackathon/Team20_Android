package com.example.team20;

import com.example.team20.domain.Member;

public class LoginInfo {

    private static final LoginInfo loginInfo = new LoginInfo();
    private Member currentMember;

    public Member getCurrentMember() {
        return currentMember;
    }
    public void setCurrentMember(Member currentMember) {
        this.currentMember = currentMember;
    }

    public static LoginInfo getInstance(){
        return loginInfo;
    }

    private LoginInfo(){

    }

}
