package entities;

public class Distributor extends User{

    private int rating; //between 0 and 5


    public Distributor(String username, String name, String email, String address,String password) {
        super(username, name, email, address,password);
    }
}
