public class BankAccount {
    private double checkings;
    private double savings;

    private static int numberOfAccounts = 0;
    private static double total = 0;
    public BankAccount(double checkings, double savings) {
        this.checkings = checkings;
        this.savings = savings;
        numberOfAccounts++;
        total += checkings;
        total += savings;
    }
    
    public static int getAccountCount() {
        return numberOfAccounts; 
    }
    public static double getTotal(){
        return total;
    }

    public double getCheckings() {
        return checkings;
    }
    
    // getter
    public double getSavings() {
        return savings;
    }


    public void deposit(String type, double number){
        if(type.equals("savings")){
            savings += number;        
        }

        else if(type.equals("checkings")){
            checkings += number;        

        }
        total += number;
    }
    
    public void withdraw(String type, double number){
        if(type.equals("savings")){
            savings -= number;
            total -= number;
        }

        else if(type.equals("checkings")){
            checkings -= number;
            total -= number;
        }
        if(savings < 0){
            savings += number;
            total += number;

            System.out.println("Not enough funds to take out");
        }
        else if(checkings < 0){
            checkings += number;
            total += number;

            System.out.println("Not enough funds to take out");
        }
    }
}