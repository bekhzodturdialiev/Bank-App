package bankapp;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class Bank implements Serializable {
	private ArrayList<Customer> customers = new ArrayList<Customer>();
	
	public void addCustomer(Customer customer) {
            if(accountExists(customer.getAccount().getAccountNumber())) {
                customer.getAccount().setAccountNumber(findValidAccountNumber());
            }
		customers.add(customer);
		
	}
        
        private int findValidAccountNumber() {
            int accountNumber = 0;
            do {
                accountNumber = Account.getNextAccountNumber();
            }while(accountExists(accountNumber));
            
            return accountNumber;
        }
        
        public boolean accountExists(int accountNumber) {
            for(Customer c : customers) {
                if(c.getAccount().getAccountNumber() == accountNumber) {
                    return true;
                }
            }
            return false;
        }

	public Customer getCustomer(int account) {
		return customers.get(account);
	}

	public ArrayList<Customer> getCustomers(){
		return customers;
	}

    Customer getCustomerByAccountNumber(int accountNumber) {
        Customer customer = null;
        for(Customer c : customers){
            if(c.getAccount().getAccountNumber() == accountNumber) {
                customer = c;
                break;
            }
        }
        return customer;
    }
    

    void removeCustomer(Customer customer) {
        customers.remove(customer);
    }
    
    void removeCustomers() {
        customers.removeAll(customers);
    }
    
    public static double round(double value, int places){
        if(places < 0) {
            throw new IllegalArgumentException();
        }
        
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.FLOOR);
        return bd.doubleValue();
    }
    
    public ArrayList<Customer> findCustomer(String query) {
        query = query.toLowerCase();
        ArrayList<Customer> cs = new ArrayList<Customer>();
        for(Customer c : this.getCustomers()) {
            if(c.getFirstName().toLowerCase().contains(query) || 
                    c.getLastName().toLowerCase().contains(query) || 
                    c.getAccount().getAccountType().toLowerCase().contains(query) || 
                    String.valueOf(c.getAccount().getAccountNumber()).toLowerCase().contains(query)) {
                cs.add(c);
            }
        }
        return cs;
    }
}
