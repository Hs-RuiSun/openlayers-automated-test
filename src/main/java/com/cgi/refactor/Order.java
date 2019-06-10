package com.cgi.refactor;

public class Order {
    private int _quantity;
    private int _itemPrice;

    public Order(int quantity, int itemPrice) {
        _quantity = quantity;
        _itemPrice = itemPrice;
    }

    double getPrice() {
        int basePrice = _quantity * _itemPrice;
        double discountFactor;
        if (basePrice > 1000) discountFactor = 0.95;
        else discountFactor = 0.98;
        return basePrice * discountFactor;
    }

    public int get_quantity() {
        return _quantity;
    }

    public void set_quantity(int _quantity) {
        this._quantity = _quantity;
    }

    public int get_itemPrice() {
        return _itemPrice;
    }

    public void set_itemPrice(int _itemPrice) {
        this._itemPrice = _itemPrice;
    }
}