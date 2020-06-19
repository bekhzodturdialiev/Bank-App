package bankapp;

import java.io.Serializable;
import java.util.Date;
import javax.naming.InsufficientResourcesException;

public abstract class Account implements Serializable{
	double fee;
	private double balance = 0;
        private Date timeCreated;
	private double interest = 0.02;
	private int accountNumber;  
        private String password;
	private static int numberOfAccounts = 100000;
        
	
	public Account() {
            accountNumber = getNextAccountNumber();
            password = createPassword();
	}
        
        public String createPassword() {
            String newPass = "abc123456"; 
            return newPass;
        }
        
        public void createPassword(String password) {
            this.password = password;
        }
        
        public boolean checkPassword(String passwordToCheck) {
            if(this.password.equals(passwordToCheck)) {
                return true;
            }
            return false;
        }
        
        public static int getNextAccountNumber() {
            return ++numberOfAccounts;
        }
	
        void setAccountNumber(int accountNumber) {
            this.accountNumber = accountNumber;
        }
        
	public double getBalance() {
            return balance;
	}
	public void setBalance(double balance) {
            this.balance = balance;
	}
        
        public Date getTimeCreated() {
            return null;
        }
        
        public void setTimeCreated() {
            this.timeCreated = new Date();
        }
        
	public double getInterest() {
            return interest;
	}
	public void setInterest(double interest) {
            this.interest = interest;
	}
	public int getAccountNumber() {
            return accountNumber;
	}
	
        public abstract String getAccountType();
        
	public void withdraw(double amount) throws InsufficientFundsException {
		this.fee = amount * 0.02;
		if(amount + fee > balance) {
                    throw new InsufficientFundsException();
		}
		balance -= amount + fee;
		checkInterest(0);
	}
	
	public void deposit(double amount) throws InvalidAmountException {
		if(amount <= 0) {
                    throw new InvalidAmountException();
		}
		checkInterest(amount);
		amount = amount + amount * interest;
		balance += amount;
	}

	
	public void transfer(double amount, Customer customerToTransfer) throws InsufficientFundsException, InvalidAmountException {
                fee = amount * 0.02;
		if(amount + fee > balance) {
                    throw new InsufficientFundsException();
		}
		amount = amount;
		balance -= amount + fee;
                customerToTransfer.getAccount().deposit(amount);
	}

	public void checkInterest(double amount) {
		if(balance + amount > 10000) {
			interest = 0.05;
		}
		else {
			interest = 0.02; 
		}
		
	}
        
        public void loanInterest(double amount) {
		if(balance + amount > 10000) {
			interest = 0.5;
		}
		else {
			interest = 0.2; 
		}
		
	}

    public double getTransactionFee() {
        return fee;
    }
    
    public void update() {
        balance = (balance * interest)+balance;
        //balance = balance * interest;
    }

    
    
}
