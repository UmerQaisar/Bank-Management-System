public class CurrentAccountUser extends User{
     

    CurrentAccountUser(String name, int an, int pin, int amount){
        super(name, an, pin,  amount);
        this.amountLimit = 500000 ;
        transactionLimit = 12 ;
    }
    CurrentAccountUser(){

    }

    public int getTransactionLimit(){
        return this.transactionLimit ;
    }
    public int getAmountLimit(){
        return this.amountLimit ;
    }
    public void getAccountType(){
        System.out.println("Current Account");
    }
}