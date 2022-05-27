package entities;

import java.math.BigDecimal;

public class Product {

    static int aux2=0;
    private int id;
    private String name;
    private String category;
    private double price;
    private double weight;
    private int warranty; //how many years does it have warranty
    private Distributor distributor;


    public Product(String name, String category, Double price, double weight, int warranty, Distributor distributor) {
        this.id = aux2+1;
        aux2 = this.id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.weight = weight;
        this.warranty = warranty;
        this.distributor = distributor;
    }

    public double getPrice() {
        return price;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", weight=" + weight +
                ", warranty=" + warranty +
                ", distributor=" + distributor +
                '}';
    }
}
