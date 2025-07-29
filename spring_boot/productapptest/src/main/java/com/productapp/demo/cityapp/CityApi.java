package com.productapp.demo.cityapp;
//external api 1500
public class CityApi {
    public String getCity(int id){
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){    }
        return "Hyderabad";
    }
}

