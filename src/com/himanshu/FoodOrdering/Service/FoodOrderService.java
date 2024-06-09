package com.himanshu.FoodOrdering.Service;

import com.himanshu.FoodOrdering.Repository.RestaurantRespository;
import com.himanshu.FoodOrdering.Repository.RestaurantRespositoryImpl;
import com.himanshu.FoodOrdering.model.Order;
import com.himanshu.FoodOrdering.model.OrderStatus;
import com.himanshu.FoodOrdering.model.Restraunt;
import com.himanshu.FoodOrdering.model.Strategy.OrderingStrategy;

import java.util.List;
import java.util.Optional;

public class FoodOrderService {

  public int orderFood(RestaurantRespository restaurantRespository,Order order,OrderingStrategy orderingStrategy)
   {
       List<Restraunt>restraunts = restaurantRespository.getAllRestaurants();
       int restruantId = orderingStrategy.assignRestraunt(order,restraunts);
       return restruantId;
   }
    public boolean assignOrder(RestaurantRespository restaurantRespository,Order order, int restaurantId) {
        boolean orderAssigned = false;
        try {
            List<Restraunt> restraunts = restaurantRespository.getAllRestaurants();
            Optional<Restraunt> restrauntOptional = restraunts.stream().filter(R -> R.getRestaurantId() == restaurantId).findFirst();
            if (restrauntOptional.isPresent()) {
                order.setOrderStatus(OrderStatus.ACCEPTED);
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
