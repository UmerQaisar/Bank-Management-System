public class User{
    private String name ;
    private int accountNumber ;
    private int pin ;
    public int amount ;
    public int transactions ;
    protected int transactionLimit  ;
    protected int amountLimit  ;

    User(String name, int an, int pin, int amount){
        this.name = name ;
        this.accountNumber = an ;
        this.pin = pin ;
        this.amount = amount ;
        this.transactions = 0 ;
    }

    User(){
        
    }

    public int getAccountNumber(){
        return this.accountNumber ;
    }

    public int getPin(){
        return this.pin ;
    }

    public void setAmount(int amount){
        this.amount = amount ;
    }

    public int getAmount(){
        return this.amount ;
    }

    public String getName(){
        return this.name ;
    }

    public int getTransactions(){
        return this.transactions ;
    }
    public int getTransactionLimit(){
        return this.transactionLimit ;
    }
    public int getAmountLimit(){
        return this.amountLimit ;
    }



}