package bankapp;

public class Checking extends Account{
	private static String accountType = "Checking";
	
	public Checking(double initialDeposit) {
		super();
		this.setBalance(initialDeposit);
		this.checkInterest(0);
	}
	
	@Override
	public String toString() {
		return "Account Type: " + accountType + " Account\n" +
				"Account Number: " + this.getAccountNumber() + "\n" +
				"Balance: " + this.getBalance() + "\n" +
				"Interest Rate: " + (this.getInterest() * 100) + "%\n";
	}

    @Override
    public String getAccountType() {
        return accountType;
    }
}
