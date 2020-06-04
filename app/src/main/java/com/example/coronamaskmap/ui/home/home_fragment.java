package com.example.coronamaskmap.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.coronamaskmap.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class home_fragment extends Fragment {
    private View view;
    private MapView mapView = null;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.home_fragment, container, false);

        mapView = (MapView)view.findViewById(R.id.map);
        mapView.onCreate(savedInstanceState);
        mapView.onResume();

        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        }catch (Exception e){
            e.printStackTrace();
        }
        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                LatLng location = new LatLng(37.485284, 126.901451); // 구로 디지털단지역 위치
                MarkerOptions markerOptions = new MarkerOptions();
                markerOptions.title("구로디지털단지역");
                markerOptions.snippet("전철역");
                markerOptions.position(location);
                googleMap.addMarker(markerOptions);

                googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 16));
            }
        });
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        mapView.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
        mapView.onStop();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onLowMemory();
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
