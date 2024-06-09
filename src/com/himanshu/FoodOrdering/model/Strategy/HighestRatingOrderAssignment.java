package com.himanshu.FoodOrdering.model.Strategy;

import com.himanshu.FoodOrdering.model.Order;
import com.himanshu.FoodOrdering.model.Restraunt;

import java.util.HashMap;
import java.util.List;

import static java.sql.Types.NULL;

public class HighestRatingOrderAssignment implements OrderingStrategy {
    @Override
    public int assignRestraunt(Order order, List<Restraunt> restraunts) {
        double maxRatingRestaurant = 0;
        int orderAssignedToRestaurant = NULL;
        for (int i = 0; i < restraunts.size(); i++) {
            HashMap<String, Integer> restrantMenu = restraunts.get(i).getMenu();
            boolean allItemFound = true;

            double currentRestaurantRating = restraunts.get(i).getRating();
            for (String orderItem : order.getOrderItems().keySet()) {
                if (!restrantMenu.containsKey(orderItem)) {
                    allItemFound = false;
                    break;
                }

            }
            if (allItemFound) {
                if (restraunts.get(i).getOrders().size() >= restraunts.get(i).getMaxOrders()) {
                    continue;
                }
                if (maxRatingRestaurant > currentRestaurantRating) {
                    maxRatingRestaurant = currentRestaurantRating;
                    orderAssignedToRestaurant = restraunts.get(i).getRestaurantId();
                }
            }
        }
        return orderAssignedToRestaurant;
    }
}
