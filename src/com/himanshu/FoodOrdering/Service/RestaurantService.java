package com.himanshu.FoodOrdering.Service;

import com.himanshu.FoodOrdering.Repository.RestaurantRespository;
import com.himanshu.FoodOrdering.Repository.RestaurantRespositoryImpl;
import com.himanshu.FoodOrdering.model.Order;
import com.himanshu.FoodOrdering.model.Restraunt;

import java.util.List;
import java.util.Optional;

public class RestaurantService {
    private final RestaurantRespository restaurantRespository;

    public RestaurantService(RestaurantRespository restaurantRespository) {
        this.restaurantRespository = restaurantRespository;
    }

    public boolean assignOrder(Order order, int restaurantId) {
        boolean orderAssigned = false;
        try {
            List<Restraunt> restraunts = restaurantRespository.getAllRestaurants();
            Optional<Restraunt> restrauntOptional = restraunts.stream().filter(R -> R.getRestaurantId() == restaurantId).findFirst();
            if (restrauntOptional.isPresent()) {
                Restraunt restraunt = restrauntOptional.get();
                restraunt.getOrders().add(order);
            }
            orderAssigned = true;

        } catch (Exception e) {
            orderAssigned = false;

        } finally {
            return orderAssigned;
        }
    }
}
