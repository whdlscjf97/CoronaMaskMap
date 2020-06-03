package com.example.coronamaskmap.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.coronamaskmap.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class home_fragment extends Fragment {
    View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.home_fragment, container, false);

        return view;
    }

    //retrofit Api를 통해 fetchstoreSale호출함
    private void fetchstoreSale(double lat, double lng, int m){
        //Retrofit Builder생성, addConverterFactory(GsonConverterFactory.create()) 전달된 json 형태를 자바 객채로 변환 시켜줌
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://8oi9s0nnth.apigw.ntruss.com").addConverterFactory(GsonConverterFactory.create()).build();
        //retrofit객채를 사용해서 MaskApi 인터페이스를 가지는 자바 객체를 생성 maskApi에는 getStoreSales api 구현되어 호출됨
        MaskApi maskApi = retrofit.create(MaskApi.class);
        //결과를 callback으로 전달받음
        maskApi.getStoresByGeo(lat,lng,m).enqueue(new Callback<StoreSaleResult>() {
            @Override
            public void onResponse(Call<StoreSaleResult> call, Response<StoreSaleResult> response) {
                //호출이 성공하였을때 http안에서 response.code가 200이면 성공적으로 전달됨
                if(response.code()==200){
                    StoreSaleResult result = response.body();
                    /***String addr = result.getStores().toString();
                     tv.setText(addr);*///출력되는지 시험해봄
                    //마커 만들때 result를 사용하면 됨
                }
            }

            @Override
            public void onFailure(Call<StoreSaleResult> call, Throwable t) {
                //호출이 실패하였을때
            }
        });
    }
}
