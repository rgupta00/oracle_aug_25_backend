package com.observer.modern;
public class Investor implements Observer {
    private String investorName;

    public Investor(String investorName) {
        this.investorName = investorName;
    }

    @Override
    public void update(String stockName, double stockPrice) {
        System.out.println("Investor " + investorName + " notified: " + stockName + " is now " + stockPrice);
    }
}
