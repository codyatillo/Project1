package Project1;

public class preCustomer {
    //made this because in the database there are defaul values
    //that dont need any inputs so the customer class wasnt able to take null values and if i
    // i gave the user the option to input activated account or not it would ruin everything
    private String users_name;
    private String users_password;
    private String name;
    private double balance;


    @Override
    public String toString() {
        return "preCustomer{" +
                "users_name='" + users_name + '\'' +
                ", users_password='" + users_password + '\'' +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }

    public preCustomer(){
    }

    public preCustomer( String users_name, String users_password, String name, double balance){

        this.users_name = users_name;
        this.users_password = users_password;
        this.name = name;
        this.balance = balance;

    }

    public String getUsers_name(){
        return users_name;
    }
    public void setUsers_name(String users_name){
        this.users_name = users_name;
    }

    public String getUsers_password(){
        return users_password;
    }
    public void setUsers_password(String users_password) {
        this.users_password = users_password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }



}
