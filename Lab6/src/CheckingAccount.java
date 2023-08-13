public class CheckingAccount extends BankAccount
{
    // Static constant representing the cost of clearing one check
    private static final double FEE = 0.15; // 15 cents

    // Constructor that takes a name and an initial amount
    public CheckingAccount(String name, double amount)
    {
        super(name, amount); // Call the superclass constructor
        setAccountNumber(getAccountNumber() + "-10"); // Update account number
    }

    // Override the withdraw method
    @Override
    public boolean withdraw(double amount)
    {
        // Calculate the total amount including the fee
        double totalAmount = amount + FEE;
        
        // Call the superclass withdraw method and return its result
        return super.withdraw(totalAmount);
    }
}
