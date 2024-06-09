package com.himanshu.FoodOrdering.Repository;

import com.himanshu.FoodOrdering.model.Restraunt;

import java.util.HashMap;
import java.util.List;

public interface RestaurantRespository {

    List<Restraunt> getAllRestaurants();

    void addRestaurant(Restraunt restraunt);

    void UpdateMenu(HashMap<String, Integer> updatedMenu, int restaurantId);

    void AddMenu(HashMap<String, Integer> updatedMenu, int restaurantId);


}
