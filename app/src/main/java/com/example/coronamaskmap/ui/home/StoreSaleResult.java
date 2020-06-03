package com.example.coronamaskmap.ui.home;

import java.util.List;

//json 형태의 데이터를 받기위한 자바 객체
public class StoreSaleResult {

    //전체 개수반환
    public int count;
    //Store객체가 array 형태로 stores에 저장
    public List<Store> stores;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Store> getStores() {
        return stores;
    }

    public void setStores(List<Store> stores) {
        this.stores = stores;
    }
}
