package com.example.team20.retrofit;

import com.example.team20.domain.Registration;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface RegistrationApi {

    // 물건 등록하기 - 정보 모두 전달 ver.
    @POST("/registration/create-all")
    Call<Registration>  createAllRegistration(@Field("itemName") String itemName,
                                              @Field("itemImage") byte[] itemImage,
                                              @Field("memo")String memo,
                                              @Field("memberId")String memberId,
                                              @Field("category")String category,
                                              @Field("itemPrice")Long itemPrice);

    // 물건 등록하기 - 아예 객체 자체를 넘기면 DB에 저장 ver.
    @POST("/registration/create")
    Call< Registration> createRegistration(@Body Registration registration);

    // 물건 삭제
    @POST("/registration/delete")
    Call<Void> deleteRegistration(@Body Registration registration);

    // 모든 물건들 조회
    @GET("/registration/findAll")
    Call<ArrayList<Registration>> findAllRegistration();


    // 카테고리별 등록한 물건들 리스트 조회
    @GET("/registration/category")
    Call< ArrayList<Registration>> findRegistrationsByCategory(@Query("category") String category);


    // 등록한 물건 정보 수정 :: 중간 확인 완료 - 사진 저장 관련 다시 확인 필요
    @POST("/change/registration")
    Call<Void> changeItemInformation(@Body Registration registration,
                                      @Field("itemName")String itemName,
                                      @Field("itemImage")byte[] itemImage,
                                      @Field("memo")String memo,
                                      @Field("category")String category,
                                      @Field("itemPrice") Long itemPrice);


    // -- 물건 정보 조회 하는 부분 -- (사실 객체만 있으면 .getName 이런식으로 하면 되긴 함)

    // 물건 이름 조회
    @GET("/registration/information/name")
    Call<String> getRegistrationName(@Body Registration registration);

    // 물건 메모 조회
    @GET("/registration/information/memo")
    Call<String> getRegistrationMemo(@Body Registration registration);

    // 물건 가격 조회
    @GET("/registration/information/price")
    Call<Long> getRegistrationPrice(@Body Registration registration);
}
