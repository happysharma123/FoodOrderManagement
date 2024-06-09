package com.himanshu.FoodOrdering.Repository;

import com.himanshu.FoodOrdering.model.Order;
import com.himanshu.FoodOrdering.model.Restraunt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class RestaurantRespositoryImpl implements  RestaurantRespository{
    List<Restraunt> restraunts = new ArrayList<>();
    @Override
    public List<Restraunt> getAllRestaurants() {
        return restraunts;
    }

    @Override
    public void addRestaurant(Restraunt restraunt) {
         restraunts.add(restraunt);
    }

    @Override
    public void UpdateMenu(HashMap<String,Integer>updatedMenu,int restaurantId)
    {
        HashMap<String,Integer> restaurantMenu = restraunts.get(restaurantId).getMenu();
        if(restaurantMenu!=null) {
            for (String dish : updatedMenu.keySet()) {
                if (restaurantMenu.containsKey(dish)) {
                    restaurantMenu.put(dish, updatedMenu.get(dish));
                }
            }
        }
    }

    @Override
    public void AddMenu(HashMap<String,Integer>updatedMenu,int restaurantId)
    {
      Optional<Restraunt>restrauntOptional = restraunts.stream().filter(R -> R.getRestaurantId()==restaurantId).findFirst();
      if(restrauntOptional.isPresent())
      {
          Restraunt restraunt = restrauntOptional.get();
          HashMap<String,Integer> restaurantMenu = restraunt.getMenu();
          if(restaurantMenu!=null) {
              for (String dish : updatedMenu.keySet()) {
                  restaurantMenu.put(dish, updatedMenu.get(dish));
              }
          }
      }
      else {
          System.out.println("No Restaurant found with id "+restaurantId);
      }

    }
}
