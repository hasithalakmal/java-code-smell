package com.cake.order;

import java.util.ArrayList;
import java.util.List;
public class OrderProcessor {
    private List<Order> orders;

    public OrderProcessor() {
        orders = new ArrayList<>();
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void printOrderSummary() {
        double totalBuyAmount = calculateTotalBuyAmount();
        double totalSellAmount = calculateTotalSellAmount();

        printOrderSummary(totalBuyAmount, totalSellAmount);
    }

    private void printOrderSummary(double totalBuyAmount, double totalSellAmount) {
        System.out.println("Order Summary:");
        System.out.println("Total Buy Amount: " + totalBuyAmount);
        System.out.println("Total Sell Amount: " + totalSellAmount);
    }

    private double calculateTotalBuyAmount() {
        double totalBuyAmount = 0.0;
        for (Order order : orders) {
            if (isBuyOrder(order)) {
                totalBuyAmount += calculateOrderAmount(order);
            }
        }
        return totalBuyAmount;
    }

    private double calculateTotalSellAmount() {
        double totalSellAmount = 0.0;
        for (Order order : orders) {
            if (isSellOrder(order)) {
                totalSellAmount += calculateOrderAmount(order);
            }
        }
        return totalSellAmount;
    }

    private boolean isBuyOrder(Order order) {
        return order.getProductName().equals("ABC") && order.getQuantity() > 0;
    }

    private boolean isSellOrder(Order order) {
        return order.getProductName().equals("ABC") && order.getQuantity() < 0;
    }

    private double calculateOrderAmount(Order order) {
        return Math.abs(order.getQuantity() * order.getPrice());
    }
}
