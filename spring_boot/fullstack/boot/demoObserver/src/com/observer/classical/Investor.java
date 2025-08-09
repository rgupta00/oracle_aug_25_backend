package com.observer.classical;

import java.util.Observable;
import java.util.Observer;

import java.util.Observable;
//this is observer who is intrested to know about price change
class Investor implements Observer {
    private String name;

    public Investor(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Investor " + name + " notified: New stock price = " + arg);
    }
}