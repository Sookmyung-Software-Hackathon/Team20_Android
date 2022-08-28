package com.example.team20.retrofit;

import com.example.team20.domain.Member;
import com.example.team20.domain.Registration;
import com.example.team20.domain.Rental;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.POST;

public interface RentalApi {

    // 물건 대여하기 -> 바로 승인됨
    // 파라미터 순서대로 : 대여할 member, 대여할 물품의 아이디() - registration.getItemId();, 대여 시간, 대여 메모
    // return 값 : 대여 신청 객체
    @POST("/rental/create")
    Call<Rental>  createRental(@Body Member member,
                             @Field("itemId") Integer itemId,
                             @Field("rentalTime") Integer rentalTime,
                             @Field("rentalMemo") String rentalMemo);



    // 물건 반납하기 -> 마이페이지. 대여 완료된 리스트로 들어감
    // 파라미터 순서대로 : 지금 대여 중인 물품(승인된 물품)의 Id (:: approveRental.getId() 하면 찾을 수 있음), 물품
    @POST("rental/return")
    Call<Void> returnRental(@Field("approveRentalId") Integer approveRentalId,
                             @Body Registration registration);

}
