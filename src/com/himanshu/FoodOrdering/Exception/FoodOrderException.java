package com.himanshu.FoodOrdering.Exception;

public class FoodOrderException extends  RuntimeException{

    public FoodOrderException() {
    }

    public FoodOrderException(String message)
    {
        super(message);
    }

}
