package com.example.coronamaskmap.ui.home;

//주소, 코드, 데이터 업데이트 시간, 위도, 경도, 약국 이름, 재고 현황, 언제 입고되었는지, 타입
public class Store {
    //주소
    public String addr;
    //식별 코드
    public String code;
    //데이터 업데이트 시간
    public String created_at;
    //위도
    public double lat;
    //경도
    public double lng;
    //약국이름
    public String name;
    //재고 상태
    public String remain_stat;
    //입고 시간
    public String stock_at;
    //판매처 유형[약국: 01, 우체국: 02, 농협: 03]
    public String type;

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemain_stat() {
        return remain_stat;
    }

    public void setRemain_stat(String remain_stat) {
        this.remain_stat = remain_stat;
    }

    public String getStock_at() {
        return stock_at;
    }

    public void setStock_at(String stock_at) {
        this.stock_at = stock_at;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
//retrofit api가 받은 json형태를 자바 객체로 변화해서 전달해줌