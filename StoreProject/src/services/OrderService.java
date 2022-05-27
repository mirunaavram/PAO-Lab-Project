package services;

import entities.InternationalDelivery;
import entities.NationalDelivery;
import entities.Order;
import entities.Product;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;

public class OrderService {

    static OrderService instance = null;
    List<Order> orderList;
    List<Order> orderHistory;

    private OrderService(){
        orderList = null;
    }

    public static OrderService getInstance(){
        if(instance == null)
        {
            instance = new OrderService();
        }
        return instance;
    }

    public void computeTransportPrice(Order order){

        System.out.println("Compute");
        double transportCost = 0;
        double totalWeight = 0;

        //se aduna costul tuturor produselor
        //daca livrarea este internationala => se adauga taxa vama si taxa de livrare internationala
        //pt livrare nationala -> taxa de easyBox
        //daca greutatea totala este mai mare decat greutatea maxim admisa -> se adauga taxa de peste greutate

        List<Product> productList = order.getProductList();

        for(Product product: productList)
        {
            transportCost += product.getPrice();
            totalWeight += product.getWeight();
        }

        if(order.getDelivery() instanceof InternationalDelivery){
            transportCost += ((InternationalDelivery) order.getDelivery()).getCustomsTaxes();
            transportCost += ((InternationalDelivery) order.getDelivery()).getCostInternationalDelivery();
        }
        else if(order.getDelivery() instanceof NationalDelivery){
            transportCost += ((NationalDelivery) order.getDelivery()).getCostEasyBox();
        }

        if(totalWeight > order.getMaximumFreeWeight())
        {
            transportCost += order.getCostOverWeight();
        }

        order.setOrderTotalCost(transportCost);

    }



}
