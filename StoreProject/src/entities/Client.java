package entities;

public class Client extends User{
    boolean juridicPerson;
    //List<Order> orderList;

    public Client(String username, String name, String email, String address, String password) {
        super(username, name, email, address, password);
    }
}
