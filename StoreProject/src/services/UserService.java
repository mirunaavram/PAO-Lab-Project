package services;

import entities.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.*;

public class UserService {

    static UserService instance = null;
    List<User> userList;
    User currentUser;
    HashMap<Integer, List<Order>> ordersHistory = new HashMap<Integer, List<Order>>();

    private UserService() {
        userList = new ArrayList<User>();
        currentUser = null;
    }

    public User getCurrentUser(){
        return currentUser;
    }

    public static UserService getInstance(){
        if(instance == null)
        {
            instance = new UserService();
        }
        return instance;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void register(User user){

        var ok = 0;
        if(userList.contains(user))
        {
            System.out.println("You are already registered");
        }
        else{
            for(User user1:userList)
                if(user.getUsername() == user1.getUsername())
                {
                    System.out.println("This username is taken, please choose another one!");
                    ok=1;
                    break;

                }
        }
        if(ok == 0){
            List<Order> aux;
            aux = new ArrayList<>();

            ordersHistory.put(user.getId(),aux);
            userList.add(user);
            System.out.println("Successfully registered");
        }
    }

    public void getUsers(){
        System.out.println("The list of users: ");
        for(User elem:userList){

            System.out.println(elem);

        }
    }


    public void signIn(String username){

        boolean signedIn = false;
        boolean findUsername = false;
        int counter = 0;
        Scanner scanner = new Scanner(System.in);
        for(User user:userList){
            if(Objects.equals(user.getUsername(), username))
            {

                while(!signedIn && counter<3) {
                    System.out.println("Introduce password: ");
                    String password = scanner.nextLine();
                    if (Objects.equals(user.getPassword(), password)) {

                        System.out.println("Successfully logged in");
                        currentUser = user;
                        signedIn = true;
                        break;
                    }
                    else{
                        System.out.println("Wrong password");
                    }
                    counter +=1 ;
                }
                if(!signedIn)
                    System.out.println("You exceeded the maximum number of attempts to sign in");
                findUsername = true;
            }
        }
        if(!findUsername)
        {
            System.out.println("No such username found");
        }

    }
    public void logOff(){
        if(currentUser != null)
        {
            currentUser = null;
            System.out.println("You have been logged off");
        }
        else{
            System.out.println("You have been already logged off");
        }
    }

    public void setTaxesPrices(User user){

        User currentUser = getCurrentUser();
        if(currentUser instanceof Distributor){

            System.out.println("Ce pret are transportul international (fara taxe vamale)?");
            Scanner scanner = new Scanner(System.in);
            String costInternationalDelivery = scanner.nextLine();
            InternationalDelivery.setCostInternationalDelivery(Double.parseDouble(costInternationalDelivery));

        }
        else{
            System.out.println("You don't have the rights to do this");
        }
    }

    public Order placeOrder(List<Product> productList, Client client){

        //daca livrarea este nationala -> delivery date este in 5 zile
        //internationala -> 14 zile

        System.out.println("Ce tip de delivery doriti? Pentru international tastati: i, pentru national tastati n");
        Scanner scanner = new Scanner(System.in);
        String deliveryType = scanner.nextLine();

        if(Objects.equals(deliveryType,"i"))
        {

            InternationalDelivery internationalDelivery = new InternationalDelivery();

            LocalDate today =  LocalDate.now();             //Today
            LocalDate deliveryDate = today.plusDays(14);     //Plus 4 days

            internationalDelivery.setDeliveryDate(deliveryDate);

            Order order = new Order(productList,client,internationalDelivery);
            ordersHistory.get(client.getId()).add(order);
            return order;

        }
        else if(Objects.equals(deliveryType,"n")){

            NationalDelivery nationalDelivery = new NationalDelivery(5);
            LocalDate today =  LocalDate.now();             //Today
            LocalDate deliveryDate = today.plusDays(5);     //Plus 4 days

            nationalDelivery.setDeliveryDate(deliveryDate);

            Order order = new Order(productList,client,nationalDelivery);
            ordersHistory.get(client.getId()).add(order);
            return order;
        }

        else
        {
            System.out.println("Eroare");
            return null;
        }
    }
    public void getHistoryByClientId(Client client){

        System.out.println("am intrat");
        for(Map.Entry<Integer, List<Order>> entry:ordersHistory.entrySet()){
            if(entry.getKey() == client.getId())
            {
                for(Order order:entry.getValue()){
                    System.out.println(order);
                }
            }
        }
    }

}
