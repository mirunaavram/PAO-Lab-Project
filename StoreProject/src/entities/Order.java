package entities;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;

public class Order {

    static int aux4=0;
    private double maximumFreeWeight;
    private int id;
    static int totalOrders;
    private List<Product> productList;
    private Client client;
    private double orderTotalCost;
    private Delivery delivery;
    private OrderReview orderReview;
    private double costOverWeight;


    public Order(List<Product> productList, Client client,  Delivery delivery) {
        this.id = aux4 +1;
        aux4 = this.id;
        totalOrders += 1;
        this.productList = productList;
        this.client = client;
        this.delivery = delivery;

    }

    public List<Product> getProductList() {
        return productList;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public double getMaximumFreeWeight() {
        return maximumFreeWeight;
    }

    public double getCostOverWeight() {
        return costOverWeight;
    }

    public void setOrderTotalCost(double orderTotalCost) {
        this.orderTotalCost = orderTotalCost;
    }

    public double getOrderTotalCost() {
        return orderTotalCost;
    }

    @Override
    public String toString() {
        return "Order{" +
                "maximumFreeWeight=" + maximumFreeWeight +
                ", id=" + id +
                ", productList=" + productList +
                ", client=" + client +
                ", orderTotalCost=" + orderTotalCost +
                ", delivery=" + delivery +
                ", orderReview=" + orderReview +
                ", costOverWeight=" + costOverWeight +
                '}';
    }
}
