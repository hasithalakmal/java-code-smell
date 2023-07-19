package com.cake.order;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

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
        Summary summary = generateSummary();
        printOrderSummary(summary);
    }

    private Summary generateSummary() {
        Summary summary = new Summary();
        summary.setTotalBuyAmount(calculateTotalBuyAmount());
        summary.setTotalSellAmount(calculateTotalSellAmount());
        return summary;
    }

    private void printOrderSummary(Summary summary) {
        System.out.println("Order Summary:");
        System.out.println("Total Buy Amount: " + summary.getTotalBuyAmount());
        System.out.println("Total Sell Amount: " + summary.getTotalSellAmount());
    }

    private double calculateTotalBuyAmount() {
        return calculateOrderSum(this::isBuyOrder);
    }

    private double calculateTotalSellAmount() {
        return calculateOrderSum(this::isSellOrder);
    }

    private double calculateOrderSum(Predicate<Order> orderType) {
        return orders.stream().filter(orderType).mapToDouble(this::calculateOrderAmount).sum();
    }

    // If need we could move these methods to order object itself
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
