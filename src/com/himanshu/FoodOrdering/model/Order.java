package com.himanshu.FoodOrdering.model;

import java.util.HashMap;
import java.util.List;

public class Order {
    int orderId;
    HashMap<String,Integer> orderItems;
    int totalPrice;
    OrderStatus orderStatus;

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Order(int orderId, HashMap<String, Integer> orderItems, OrderStatus orderStatus) {
        this.orderId = orderId;
        this.orderItems = orderItems;

        this.orderStatus = orderStatus;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public  HashMap<String,Integer>  getOrderItems() {
        return orderItems;
    }

    public void setOrderItems( HashMap<String,Integer>  orderItems) {
        this.orderItems = orderItems;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
}
