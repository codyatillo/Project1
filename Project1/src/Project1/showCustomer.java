package Project1;

public class showCustomer {
   //this was made so the it only returned a specific values in this case the customr name and balance

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




}
