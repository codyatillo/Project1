package Project1;

public class Customer { //more so used to get and hold values
    private int id; //account number
    private String users_name;
    private String users_password;
    private String name;
    private double balance;
    private boolean isVeri;


    //private int withdraw; //will probably be a function
    //private int deposit; //will probably be a function
    //private String users_name;
    //private String user_password;


    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", users_name='" + users_name + '\'' +
                ", users_password='" + users_password + '\'' +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                ", isVeri=" + isVeri +
                '}';
    }

    public Customer(){
    }

    public Customer( String users_name, String users_password,int id, String name, double balance, boolean isVeri){

        this.users_name = users_name;
        this.users_password = users_password;
        this.id= id;
        this.name = name;
        this.balance = balance;
        this.isVeri = isVeri;

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

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }


    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean isVeri() {
        return isVeri;
    }
    public void setVeri(boolean veri) {
        isVeri = veri;
    }



}

