package com.himanshu.FoodOrdering.model.Strategy;

import com.himanshu.FoodOrdering.model.Order;
import com.himanshu.FoodOrdering.model.OrderItem;
import com.himanshu.FoodOrdering.model.OrderStatus;
import com.himanshu.FoodOrdering.model.Restraunt;

import java.util.HashMap;
import java.util.List;

import static java.sql.Types.NULL;

public class LowestPriceOrderAssignStrategy implements OrderingStrategy {
    @Override
    public int assignRestraunt(Order order, List<Restraunt> restraunts) {
        int orderPrice = Integer.MAX_VALUE;
        int orderAssignedToRestaurant = NULL;
        for (int i = 0; i < restraunts.size(); i++) {
            HashMap<String, Integer> restrantMenu = restraunts.get(i).getMenu();
            boolean allItemFound = true;

            int currentOrderPrice = 0;
            for (String orderItem : order.getOrderItems().keySet()) {
                if (!restrantMenu.containsKey(orderItem)) {
                    allItemFound = false;
                    break;
                } else {
                    currentOrderPrice = currentOrderPrice + order.getOrderItems().get(orderItem) * restrantMenu.get(orderItem);
                }
            }
            if (allItemFound) {
                long acceptedOrderes = restraunts.get(i).getOrders().stream().filter(order1 -> OrderStatus.ACCEPTED.equals(order1.getOrderStatus())).count();
                if (acceptedOrderes >= restraunts.get(i).getMaxOrders()) {
                    continue;
                }
                if (orderPrice > currentOrderPrice) {
                    orderPrice = currentOrderPrice;
                    orderAssignedToRestaurant = restraunts.get(i).getRestaurantId();
                }
            }
        }
        return orderAssignedToRestaurant;
    }
}
