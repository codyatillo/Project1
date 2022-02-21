package Project1;

public class CustomerDaoFactory{
    private static CustomerDao dao;

    public CustomerDaoFactory(){

    }

    public static CustomerDao getCustomerDao() {
        if(dao == null){
            dao =new CustomerDaoImp();
        }
        return dao;
    }
}

