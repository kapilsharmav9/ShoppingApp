package com.example.shoppingapp.Model;

public class HorizontalProductmodel {
    private int productimage;
    private String productName;
    private  String productDescription;
    private  String productPrice;

    public HorizontalProductmodel(int productimage, String productName, String productDescription, String productPrice) {
        this.productimage = productimage;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
    }

    public HorizontalProductmodel() {
    }

    public int getProductimage() {
        return productimage;
    }

    public void setProductimage(int productimage) {
        this.productimage = productimage;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }
}
