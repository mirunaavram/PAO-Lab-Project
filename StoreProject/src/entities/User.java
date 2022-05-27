package entities;

public abstract class User {

    static int totalUsers;
    static int aux=0;
    private int id;
    protected String username;
    protected String name;
    protected String email;
    protected String address;
    protected String password;

    public User(String username, String name, String email, String address, String password) {

        this.id = aux+1;
        aux = this.id;
        totalUsers +=1;
        this.username = username;
        this.name = name;
        this.email = email;
        this.address = address;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
