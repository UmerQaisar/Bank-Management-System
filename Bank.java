import java.util.*;

public class Bank{
    
    private ArrayList<User> user;
    private static int accountNo ;
    private int driverAn ;
    Scanner scanner = new Scanner(System.in) ;

    Bank(){
        user = new ArrayList<>() ;
        user.add(new CurrentAccountUser("Umer" , 1 , 1432 , 10000)) ;
        user.add(new CurrentAccountUser("Sameer" , 2 , 1324 , 20000)) ;
        user.add(new CurrentAccountUser("Suqaina", 3, 6789, 15000));
        user.add(new SavingAccountUser("Mahum" , 4 , 9632 , 20000)) ;
        user.add(new SavingAccountUser("Sahil" , 5 , 6754 , 25000)) ;
        accountNo = 6 ;
    }

    public void createSavingAccount(){
         String sname ;
         int spin ;
         int samount ;
                    System.out.println("Enter your name");
                    sname = scanner.nextLine() ;
                    System.out.println("Set a pin for your Acoount");
                    spin = scanner.nextInt() ;
                    System.out.println("Enter Initial Amount");
                    samount = scanner.nextInt() ;
        user.add(new SavingAccountUser(sname, accountNo , spin , samount)) ; 
        System.out.println("You have successfully created an Saving Account"); 
        System.out.println("Your Account Number is : " + accountNo); 
        accountNo ++ ;         
    }

    public void createCurrentAccount(){
        String cname ;
        int cpin ;
        int camount ;
                    System.out.println("Enter your name");
                    cname = scanner.nextLine() ;
                    System.out.println("Set a pin for your Acoount");
                    cpin = scanner.nextInt() ;
                    do{
                        System.out.println("Enter Initial Amount");
                        camount = scanner.nextInt() ;
                    }while(camount < 0 ) ;
        user.add(new CurrentAccountUser(cname, accountNo , cpin , camount)) ; 
        System.out.println("--------------------------------------------------------------------");
        System.out.println("You have successfully created a Current Account"); 
        System.out.println("--------------------------------------------------------------------");
        System.out.println("Your Account Number is : " + accountNo); 
        System.out.println("\n Returning to Main Menu .. ");
        accountNo ++ ;
    }
    
    public User searchByAn(int an)
    {
        for(User usr : user)
        {
            if(an == usr.getAccountNumber())
            {   
               
                return usr;
                
            }
        }
        return null;
    }

    public int returnAn(){
        return this.driverAn ;
    }

    public boolean logIn(){
        int lan ;
        int lpin ;
            System.out.println("Enter your Account Number");
            lan = scanner.nextInt() ;
            driverAn = lan ;
            System.out.println("Enter your Pin");
            lpin = scanner.nextInt() ;
        User aUser = searchByAn(lan) ;
        if(aUser.getPin() == lpin){
            System.out.println("------------------------------------------------------------------------");
            System.out.println("\t" + aUser.getName() + " Has successfully logged into his/her Account");
            System.out.println("------------------------------------------------------------------------");
            return true ;

        }

        else{
            System.out.println("You may have entered a wrong Account Number or pin \n Please try Again");
            return false ;
        }
    }
    
    
    public boolean deposit(int dan){
        User bUser = searchByAn(dan) ;
        int amount ;
        boolean flag ;
        
        do{
            flag = false ;
            System.out.println("Enter Amount .. ");
            amount = scanner.nextInt() ;
            if(amount > bUser.getAmountLimit() || amount < 0 ){
                System.out.println("Enter the amount again ...");
                flag = true ;
            }
        }while(flag) ;
        bUser.amount = bUser.getAmount() + amount ;
        System.out.println("......................");
        System.out.println(bUser.getName() + " Has successfully deposited RS : " + amount);
        System.out.println("......................");
        bUser.transactions ++ ;
        return true ;
        
    
    }

    public boolean withdraw(int wan){
        User cUser = searchByAn(wan) ;
        int amount ;
        boolean flag ;

        do{
            flag = false ;
            System.out.println("Enter Amount .. ");
            amount = scanner.nextInt() ;
            if(amount > cUser.getAmountLimit() || amount < 0 || amount > cUser.getAmount() ){
                System.out.println("Enter the amount again ...");
                flag = true ;
            }
        }while(flag) ;

        cUser.amount = cUser.getAmount() - amount ;
        System.out.println("......................");
        System.out.println(cUser.getName() + " Has successfully withdrawn RS : " + amount);
        System.out.println("......................");
        cUser.transactions ++ ;
        return true ;
    
    }

    public boolean transfer(int tan ){
        User dUser = searchByAn(tan) ;
        int amount ;
        boolean flag ;
        System.out.println("Enter Account Number of the recipient");
        int san = scanner.nextInt() ;
        User eUser = searchByAn(san) ;
        
        do{
            flag = false ;
            System.out.println("Enter Amount .. ");
            amount = scanner.nextInt() ;
            if(amount > dUser.getAmountLimit() || amount < 0 || amount > dUser.getAmount() ){
                System.out.println("Enter the amount again ...");
                flag = true ;
            }
        }while(flag) ;

        dUser.amount = dUser.getAmount() - amount ;
        eUser.amount = eUser.getAmount() + amount ;
        System.out.println("......................");
        System.out.println(dUser.getName() + " Has successfully transfered RS : " + amount + " to " + eUser.getName());
        System.out.println("......................");
        dUser.transactions ++ ;
        return true ;
    }


    public void showInfo(int ian ){
        User fUser = searchByAn(ian) ;
        System.out.println("......................");
        System.out.println("..... " + fUser.getName() + " ....");
        System.out.println("......................");
        System.out.println("Account Number : " + fUser.getAccountNumber());
        System.out.println("Balance : " + fUser.getAmount());
        System.out.println("Total Transactions : " + fUser.getTransactions());

    }

}
