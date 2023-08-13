public class SavingsAccount extends BankAccount
{
    private static final double RATE = 0.025; // 2.5% - Annual interest rate

    // Counter to keep track of savings account instances
    private static int savingsNumber = 0;

    // Instance variable to store the specific account number for this savings account
    private int accountNumber;

    // Constructor to create a new SavingsAccount instance
    public SavingsAccount(String name, double amount)
    {
        // Call the constructor of the superclass (BankAccount)
        super(name, amount);
        
        // Increment the savingsNumber counter for each new savings account
        savingsNumber++;
        
        // Set the accountNumber for this savings account instance
        accountNumber = savingsNumber;

        // Set the accountNumber using the concatenation of the original account number and the adjusted savingsNumber
        setAccountNumber(super.getAccountNumber().split("-")[0] + "-" + (accountNumber - 1));
    }

    // Method to calculate and add monthly interest to the balance
    public void postInterest()
    {
        // Calculate the interest based on the balance and the monthly interest rate
        double interest = getBalance() * RATE / 12;
        
        // Deposit the calculated interest amount into the account
        deposit(interest);
    }

    // Override the getAccountNumber method to adjust the format of the account number
    @Override
    public String getAccountNumber()
    {
        // Adjust the format of the account number using the original account number and adjusted savingsNumber
        return super.getAccountNumber().split("-")[0] + "-" + (accountNumber - 1);
    }

    // Copy constructor to create a new SavingsAccount instance based on an existing one
    public SavingsAccount(SavingsAccount oldAccount, double amount)
    {
        // Call the copy constructor of the superclass (BankAccount)
        super(oldAccount, amount);

        // Increment the savingsNumber counter for each new savings account
        savingsNumber++;

        // Set the accountNumber for this new savings account instance
        accountNumber = savingsNumber;

        // Set the accountNumber using the concatenation of the original account number and the adjusted savingsNumber
        setAccountNumber(super.getAccountNumber().split("-")[0] + "-" + (accountNumber - 1));
    }
}
