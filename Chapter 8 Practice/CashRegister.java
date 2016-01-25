


public class CashRegister
{
    int payment;
    
    public CashRegister()
    {
    }

    public void recievePayment(int numberOfCoins, Coin coin)
    {
        payment += numberOfCoins * coin.getValue();
    }
    
    public Coin giveChange(double amountOwed)
    {
        int change = amountOwed - payment;
    }

}
