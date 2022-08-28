package com.example.team20.retrofit;

import com.example.team20.domain.ApproveRental;
import com.example.team20.domain.CompleteRental;
import com.example.team20.domain.Member;
import com.example.team20.domain.Registration;

import java.util.ArrayList;
import java.util.Optional;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface MemberApi {

    // 회원 가입
    @POST("/member/join")
    Call<Member> save(@Body Member member);

    // 로그인
    @GET("/member/login")
    Call<Member> login(@Query("memberId") String memberId, @Query("password") String password);

    // 모든 회원 리스트 조회하기
    @GET("/find/all_member")
    Call<ArrayList<Member>> findAllMembers();

    // id로 회원 조회하기 - 실패할 경우 null return
    @GET("/find/member")
    Call<Optional<Member>> findMemberById(@Query("memberId") String memberId);

    // 회원 탈퇴
    @POST("/member/leave")
    Call<Void> leave(@Body Member member);



    // -- 마이페이지 기능 --

    // 회원 프로필 사진 바꾸기
    @GET("/myPage/changeImage")
    Call<byte[]> changeProfileImage(@Body Member member, @Field("changeImage") byte[] changeImage);

    // 회원 이름 조회
    @GET("/myPage/getName")
    Call<String> getName(@Body Member member);

    // 회원 포인트 조회
    @GET("/myPage/getPoint")
    Call<Integer> getPoint(@Body Member member);


    // 회원이 등록한 상품 목록 조회
    @GET("/myPage/getRegistrationList")
    Call<ArrayList<Registration>> getRegistrationList (@Body Member member);

    // 회원이 대여 중인 상품 목록 조회
    @GET("/myPage/getApproveRentalList")
    Call<ArrayList<ApproveRental>> getApproveRentalList (@Body Member member);

    // 회원이 대여 완료한 상품 목록 조회
    @GET("/myPage/getCompleteRentalList")
    Call<ArrayList<CompleteRental>> getCompleteRentalList (@Body Member member);






}
