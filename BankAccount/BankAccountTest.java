public class BankAccountTest {
    public static void main(String[] args) {
        BankAccount person1 = new BankAccount(1000, 2000);
        BankAccount person2 = new BankAccount(500, 5000);
        person1.deposit("savings", 500);
        person1.withdraw("savings", 1000);

        System.out.println(person1.getCheckings());
        System.out.println(person1.getSavings());
        System.out.println(BankAccount.total());
    }
}