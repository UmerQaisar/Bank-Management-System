public class SavingAccountUser extends User{
     

    SavingAccountUser(String name, int an, int pin, int amount){
        super(name, an, pin,  amount);
        this.amountLimit = 250000 ;
        transactionLimit = 6 ;
    }
    SavingAccountUser(){

    }

    public int getTransactionLimit(){
        return this.transactionLimit ;
    }
    public int getAmountLimit(){
        return this.amountLimit ;
    }

    public void getAccountType(){
        System.out.println("Saving Account");
    }
}