package Project1;

public class showCustomer {
    private String name;
    private double balance;

    @Override
    public String toString() {
        return "showCustomer{" +
                "name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }

    public showCustomer(){
    }

    public showCustomer( String name, double balance){
        this.name = name;
        this.balance = balance;
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
