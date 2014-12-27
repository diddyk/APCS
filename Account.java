// David Kong		10/28/11
// Account.java

//variable private - no access to variable, must use getter/setter 
//PUBLIC methods

//private -> only accessable by class, no other classes, not even subclasses
//protected -> accessable by sublcasses
//public -> accessable by all

public class Account 
{
    private double balance;

    // Constructor to initialize balance [empty args]
    public Account( double amount )
    {
        balance = amount;
    }

    // Overloaded constructor for empty balance
    public Account()
    {
        balance = 0.0;
    }

	//accessor methods [because private variable]
    public void deposit( double amount )
    {
        balance += amount;
    }

    public double withdraw( double amount )
    {
        // See if amount can be withdrawn
        if (balance >= amount)
        {
            balance -= amount;
            return amount;
        }
        else
            // Withdrawal not allowed
            return 0.0;
    }
	
    public void setbalance (double b)
    {
        balance = b;
    }

    public double getbalance ( )
    {
        return balance;
    }
}  
