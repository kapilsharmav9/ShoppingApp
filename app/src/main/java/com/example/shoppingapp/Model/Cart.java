package com.example.shoppingapp.Model;

public class Cart {
    private  String ItemName;
    private Double ItemPrice;
    private String ItemQuantity;

    public Cart(String itemName, Double itemPrice, String itemQuantity) {
        ItemName = itemName;
        ItemPrice = itemPrice;
        ItemQuantity = itemQuantity;
    }

    public Cart() {
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String itemName) {
        ItemName = itemName;
    }

    public Double getItemPrice() {
        return ItemPrice;
    }

    public void setItemPrice(Double itemPrice) {
        ItemPrice = itemPrice;
    }

    public String getItemQuantity() {
        return ItemQuantity;
    }

    public void setItemQuantity(String itemQuantity) {
        ItemQuantity = itemQuantity;
    }
}
