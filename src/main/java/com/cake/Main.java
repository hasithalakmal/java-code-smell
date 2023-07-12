package com.cake;

public class Main {
    public static void main(String[] args) {
        OrderProcessor orderProcessor = new OrderProcessor();

        orderProcessor.addOrder(new Order("O1", "ABC", 100, 10.0));
        orderProcessor.addOrder(new Order("O2", "XYZ", -50, 20.0));
        orderProcessor.addOrder(new Order("O3", "ABC", -200, 15.0));
        orderProcessor.addOrder(new Order("O4", "ABC", 150, 12.0));

        orderProcessor.printOrderSummary();
    }
}