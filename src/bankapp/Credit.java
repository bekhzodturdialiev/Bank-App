package bankapp;

public class Credit extends Account{
	private static String accountType = "Credit";
	
	public Credit(double creditAmount) {
		super();
		this.setBalance(creditAmount);
		this.loanInterest(0);
	}
        
        public void rePay() {
            return;
        }
	
	@Override
	public String toString() {
		return "Account Type: " + accountType + " Account\n" +
				"Account Number: " + this.getAccountNumber() + "\n" +
				"Balance: " + this.getBalance() + "\n" +
				"Credit Rate: " + (this.getInterest() * 100) + "%\n";
	}

    @Override
    public String getAccountType() {
        return accountType;
    }
}
