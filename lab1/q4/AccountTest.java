package lab1.q4;

public class AccountTest {

    public static void main(String[] args) {

        Account account1 =
            new Account("Peter", 1000);

        System.out.println("Name: " + account1.getName());
        System.out.println("Balance: " + account1.getBalance());

        account1.deposit(500);

        System.out.println();
        System.out.println("After deposit:");

        System.out.println(
            "Balance: " + account1.getBalance()
        );

        account1.deposit(-100);

        System.out.println();
        System.out.println("After invalid deposit:");

        System.out.println(
            "Balance: " + account1.getBalance()
        );

        account1.setName("John");

        System.out.println();
        System.out.println(
            "New name: " + account1.getName()
        );

        Account account2 =
            new Account("Alice", -500);

        System.out.println();
        System.out.println(
            "Account 2 balance: " +
            account2.getBalance()
        );
    }
}
