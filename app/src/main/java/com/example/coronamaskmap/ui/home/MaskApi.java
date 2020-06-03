package com.example.coronamaskmap.ui.home;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

//api호출을 위해 인터페이스 만듬
public interface MaskApi {
    @Headers("Accept:application/json")
    @GET("/corona19-masks/v1/storesByGeo/json")
    Call<StoreSaleResult> getStoresByGeo(@Query("lat") double lat, @Query("lng") double lng, @Query("m") int m);
    //lat:위도,lng:경도,m:반경 3가지 파라메타를 가지고 getStoresByGeo Api를 호출하면 그 결과로 StoreSaleResult가 반환되는 Api 정의
}
