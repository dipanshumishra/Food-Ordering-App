package com.example.foodorderapp.Models;

public class OrdersModel {

      int Order_Model_Image;
      String  Order_Model_Name , Order_Model_Price , Order_Model_Number;

    public OrdersModel(int order_Model_Image, String order_Model_Name, String order_Model_Price, String order_Model_Number) {
        Order_Model_Image = order_Model_Image;
        Order_Model_Name = order_Model_Name;
        Order_Model_Price = order_Model_Price;
        Order_Model_Number = order_Model_Number;
    }

    public OrdersModel() {}

    public int getOrder_Model_Image() {
        return Order_Model_Image;
    }

    public void setOrder_Model_Image(int order_Model_Image) {
        Order_Model_Image = order_Model_Image;
    }

    public String getOrder_Model_Name() {
        return Order_Model_Name;
    }

    public void setOrder_Model_Name(String order_Model_Name) {
        Order_Model_Name = order_Model_Name;
    }

    public String getOrder_Model_Price() {
        return Order_Model_Price;
    }

    public void setOrder_Model_Price(String order_Model_Price) {
        Order_Model_Price = order_Model_Price;
    }

    public String getOrder_Model_Number() {
        return Order_Model_Number;
    }

    public void setOrder_Model_Number(String order_Model_Number) {
        Order_Model_Number = order_Model_Number;
    }
}


