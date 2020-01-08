import java.util.* ;

public class Driver{
    public static void main(String argu[]) {
        Bank bank = new Bank() ;
        Scanner scanner = new Scanner(System.in) ;
        int mainMenu ;
        int accountType ;
        int options ;
        
        System.out.println(".......................................................................");
        System.out.println(".......................Bank Management System..........................");
        System.out.println(".......................................................................");
        

        do{
            System.out.println(".....Main Menu.....");
            System.out.println("1 .. Creat Account ");
            System.out.println("2 .. Log into your Account");
            System.out.println("3 .. Exit ");
            
            mainMenu = scanner.nextInt() ;
            switch(mainMenu){
                case 1 :
                    System.out.println("\tCreating Account .....");
                    System.out.println("..Account Type..");
                    System.out.println("1 .. Saving Account");
                    System.out.println("2 .. Current Account");
                    accountType = scanner.nextInt() ;

                    switch(accountType){
                        case 1 :
                            bank.createSavingAccount();
                        break ;   
                        case 2 :
                            bank.createCurrentAccount();
                        break ;    
                    
                    }


                break ;
                case 2 :
                if( bank.logIn() == true ){
                    int accountNumber = bank.returnAn() ;
                    System.out.println("\n\t\t WELCOME");
                    
                    do{
                        System.out.println("\n Options\t");
                        System.out.println("1 .. Withdraw Money");
                        System.out.println("2 .. Deposit Money");
                        System.out.println("3 .. Transfer Money");
                        System.out.println("4 .. Check Account Info");
                        System.out.println("5 .. Back to Main Menu");
                        options = scanner.nextInt() ;

                        switch(options){
                            case 1 :
                                bank.withdraw(accountNumber) ;
                            break ; 
                            case 2 :
                                bank.deposit(accountNumber) ;
                            break ;    
                            case 3 :
                                bank.transfer(accountNumber) ;
                            break ;
                            case 4 :
                                bank.showInfo(accountNumber) ;
                            break ;
                        }

                    }while(!(options == 5)) ;

                };
                

                break ;
                
            }

        }while(!(mainMenu == 3)) ;
    }

}

