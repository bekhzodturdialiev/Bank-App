package bankapp;

import java.io.Serializable;

public class Customer implements Serializable{

	private String firstName;
	private String lastName;
	private String ssn;
	private Account account;
        private boolean isClerk = false;

	public Account getAccount() {
            return account;
	}
        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }
        
        public String getSsn() {
            return ssn;
        }
        
	public void setAccount(Account account) {
            this.account = account;
	}

	public Customer(String firstName, String lastName, String ssn, Account account) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.ssn = ssn;
            this.account = account;
	}
        
        public Customer(String firstName, String lastName, String password, String ssn, Account account) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.ssn = ssn;
            this.account = account;
            this.account.createPassword(password);
	}

   
}
