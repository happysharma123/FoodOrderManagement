package com.himanshu.FoodOrdering.model;

public enum OrderItem {
    VEG_BIRYANI("Veg Biryani"),
    CHICKEN_BIRYANI("Chicken Biryani"),
    IDLI("Idli");

    private final String itemName;

    OrderItem(String itemName) {
        this.itemName = itemName;
    }

    public String getItemName() {
        return itemName;
    }

    @Override
    public String toString() {
        return itemName;
    }

}
