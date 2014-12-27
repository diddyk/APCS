// David Kong		10/28/11
// InterestBearingAccount.java

public class InterestBearingAccount extends Account
{
    // Default interest rate of 7.95 percent (const)
    private static double default_interest = 7.95;

    // Current interest rate
    private double interest_rate;

    // Overloaded constructor accepting balance and an interest rate
    public InterestBearingAccount( double amount, double interest)
    {
        setbalance(amount);
        interest_rate = interest;
    }

    // Overloaded constructor accepting balance with a default interest rate
    public InterestBearingAccount( double amount )
    {
        setbalance(amount);
        interest_rate = default_interest;
    }

    // Overloaded constructor with empty balance and a default interest rate
    public InterestBearingAccount()
    {
        setbalance(0.0);
        interest_rate = default_interest;
    }
	
    public void add_monthly_interest()
    {
        // Add interest to our account
        setbalance(getbalance() + (getbalance() * interest_rate / 100) / 12);
    }
}
