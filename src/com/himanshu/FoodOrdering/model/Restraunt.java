package com.himanshu.FoodOrdering.model;

import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Restraunt {
    int restaurantId;
    Queue<Order> orders;

    public Restraunt(int restaurantId, int maxOrders, HashMap<String, Integer> menu, double rating) {
        this.restaurantId = restaurantId;
        this.maxOrders = maxOrders;
        this.menu = menu;
        this.rating = rating;
        this.orders = new LinkedList<>();
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    private int maxOrders;
    private HashMap<String, Integer> menu;
    private double rating;


    public int getMaxOrders() {
        return maxOrders;
    }

    public void setMaxOrders(int maxOrders) {
        this.maxOrders = maxOrders;
    }

    public HashMap<String, Integer> getMenu() {
        return menu;
    }

    public void setMenu(HashMap<String, Integer> menu) {
        this.menu = menu;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }


    public Queue<Order> getOrders() {
        return orders;
    }

    public void setOrders(Queue<Order> orders) {
        this.orders = orders;
    }
}
