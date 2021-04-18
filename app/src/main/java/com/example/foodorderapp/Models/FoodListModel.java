package com.example.foodorderapp.Models;

public class FoodListModel {

    int FoodListModelPic;
    String FoodListModelName , FoodListModelPrice , FoodListModelDescription ;

    public FoodListModel(int foodListModelPic, String foodListModelName, String foodListModelPrice, String foodListModelDescription) {
        FoodListModelPic = foodListModelPic;
        FoodListModelName = foodListModelName;
        FoodListModelPrice = foodListModelPrice;
        FoodListModelDescription = foodListModelDescription;
    }

    public int getFoodListModelPic() {
        return FoodListModelPic;
    }

    public void setFoodListModelPic(int foodListModelPic) {
        FoodListModelPic = foodListModelPic;
    }

    public String getFoodListModelName() {
        return FoodListModelName;
    }

    public void setFoodListModelName(String foodListModelName) {
        FoodListModelName = foodListModelName;
    }

    public String getFoodListModelPrice() {
        return FoodListModelPrice;
    }

    public void setFoodListModelPrice(String foodListModelPrice) {
        FoodListModelPrice = foodListModelPrice;
    }

    public String getFoodListModelDescription() {
        return FoodListModelDescription;
    }

    public void setFoodListModelDescription(String foodListModelDescription) {
        FoodListModelDescription = foodListModelDescription;
    }
}
