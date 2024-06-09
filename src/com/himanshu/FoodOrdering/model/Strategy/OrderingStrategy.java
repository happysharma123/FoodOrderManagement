package com.himanshu.FoodOrdering.model.Strategy;

import com.himanshu.FoodOrdering.model.Order;
import com.himanshu.FoodOrdering.model.Restraunt;

import java.util.List;

public interface OrderingStrategy {
    int assignRestraunt(Order order,List<Restraunt>restraunts);
}
