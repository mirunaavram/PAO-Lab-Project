import entities.*;
import services.OrderService;
import services.UserService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        User user1 = new User("ana", "mara", "","","maca"){};
        User user2 = new User("denisa", "mara", "","",""){};

        Client client1 = new Client("ana", "mara", "","","maca");

        Distributor distributor1 = new Distributor("Samsung","samsung@office.ro","LA","LA","ala");
        Product product1 = new Product("SamsungA52","electronice", 52.0,2,2,distributor1);
        Product product2 = new Product("SamsungA6","electronice", 600.0,2,3,distributor1);
        NationalDelivery delivery1 = new NationalDelivery(5);
        NationalDelivery delivery2 = new NationalDelivery(10);
        InternationalDelivery delivery3 = new InternationalDelivery();

        List<Product> lisProducts = new ArrayList<>();
        lisProducts.add(product1);
        lisProducts.add(product2);
        OrderService orderService = OrderService.getInstance();
        UserService userService = UserService.getInstance();


        //-----------------Register part-----------
        userService.register(client1);
        userService.register(user2);
        userService.register(distributor1);

        ///daca ma loghez cu user de tip distribuitor pot seta taxele de transport
        userService.signIn("ana");
        User currentUser = userService.getCurrentUser();
        userService.setTaxesPrices(currentUser);
        //System.out.println(delivery3.getCostInternationalDelivery());
        //userService.getUsers();
        //userService.logOff();

        //test plaseaza comanda

        Order order = userService.placeOrder(lisProducts,client1);
        //test calculeaza pret comanda

        orderService.computeTransportPrice(order);
        System.out.println("Total cost: "+ order.getOrderTotalCost());
        System.out.println("The order will be delivered by Date: " + order.getDelivery().getDeliveryDate());

        //am ramas la hashmap in userservice
        userService.getHistoryByClientId(client1);
    }

}
