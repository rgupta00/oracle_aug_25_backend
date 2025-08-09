package com.observer.classical;

import java.util.Observable;
//this is Observable whose price change we are intrested
class Stock extends Observable {
    private double price;

    public void setPrice(double price) {
        this.price = price;
        setChanged();
        notifyObservers(price);
    }
}
