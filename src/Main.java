import com.himanshu.FoodOrdering.Repository.RestaurantRespository;
import com.himanshu.FoodOrdering.Repository.RestaurantRespositoryImpl;
import com.himanshu.FoodOrdering.Service.FoodOrderService;
import com.himanshu.FoodOrdering.model.Order;
import com.himanshu.FoodOrdering.model.Restraunt;
import com.himanshu.FoodOrdering.model.Strategy.HighestRatingOrderAssignment;
import com.himanshu.FoodOrdering.model.Strategy.LowestPriceOrderAssignStrategy;
import com.himanshu.FoodOrdering.model.Strategy.OrderingStrategy;

import java.awt.*;
import java.util.HashMap;

import static com.himanshu.FoodOrdering.model.OrderStatus.ACCEPTED;

public class Main {
    public static void main(String[] args) {
        HashMap<String,Integer>menu1 = new HashMap<>();
        menu1.put("Veg Biryani",100);
        menu1.put("Chicken Biryani",150);
        Restraunt R1 = new Restraunt(1,5,menu1,4);

        HashMap<String,Integer>menu2 = new HashMap<>();
        menu2.put("Chicken Biryani",150);
        menu2.put("Idli",10);
        menu2.put("Dosa",50);
        menu2.put("Veg Biryani",80);


        Restraunt R2 = new Restraunt(2,5,menu2,4);

        HashMap<String,Integer>menu3 = new HashMap<>();
        menu3.put("Gobi Manchurian",150);
        menu3.put("Idli",15);
        menu3.put("Chicken Biryani",175);
        menu3.put("Dosa",30);

        Restraunt R3 = new Restraunt(3,1,menu3,4.95);

        RestaurantRespository restaurantRespository = new RestaurantRespositoryImpl();
        restaurantRespository.addRestaurant(R1);
        restaurantRespository.addRestaurant(R2);
        restaurantRespository.addRestaurant(R3);

        HashMap<String,Integer> updatedMenu = new HashMap<>();
        updatedMenu.put("Chicken65",250);


        restaurantRespository.AddMenu(updatedMenu,1);

        HashMap<String,Integer> updatedMenu2  = new HashMap<>();
        updatedMenu2.put("Chicken Biryani",150);
        HashMap<String,Integer>orderItems = new HashMap<>();
        orderItems.put("Idli",3);
        orderItems.put("Dosa",1);

        Order order = new Order(1,orderItems,null);
        OrderingStrategy orderingStrategyLowestPrice = new LowestPriceOrderAssignStrategy();
        FoodOrderService foodOrderService = new FoodOrderService();
        int OrderAssignedToRestaurantId =  foodOrderService.orderFood(restaurantRespository,order,orderingStrategyLowestPrice);
        foodOrderService.assignOrder(restaurantRespository,order,OrderAssignedToRestaurantId );

        OrderingStrategy orderingStrategyHighestRating = new HighestRatingOrderAssignment();
        HashMap<String,Integer>orderItems2 = new HashMap<>();
        orderItems2.put("Veg Birayni",3);
        Order order2 = new Order(1,orderItems2,null);

        int OrderAssignedToRestaurantIdForHighestRating = foodOrderService.orderFood(restaurantRespository,order,orderingStrategyHighestRating);
        foodOrderService.assignOrder(restaurantRespository,order,OrderAssignedToRestaurantIdForHighestRating);




    }
}