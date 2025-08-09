package com.observer.modern;
public class Main {
    public static void main(String[] args) {
        Stock googleStock = new Stock("GOOGLE", 2800.00);

        Investor investor1 = new Investor("ravi");
        Investor investor2 = new Investor("amit");

        googleStock.registerObserver(investor1);
        googleStock.registerObserver(investor2);

        googleStock.setPrice(2850.00); // Both investors will be notified
        googleStock.setPrice(2900.00);

        googleStock.removeObserver(investor1);
        googleStock.setPrice(2950.00); // Only Bob will be notified
    }
}
