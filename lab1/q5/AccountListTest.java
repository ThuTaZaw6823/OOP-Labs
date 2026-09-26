package lab1.q5;

import lab1.q4.Account;

public class AccountListTest {

    public static void main(String[] args) {

        AccountList al = new AccountList(3);

        boolean success =
            al.appendAccount(
                new Account("Oak", 1.0)
            );

        System.out.println(success);

        success =
            al.appendAccount(
                new Account("Two", 0.1)
            );

        System.out.println(success);

        Account account =
            al.getAccount(2);

        System.out.println(account);

        account =
            al.getAccount(1);

        System.out.println(
            account.getBalance()
        );

        success =
            al.appendAccount(
                new Account("tmp", 0)
            );

        System.out.println(success);

        success =
            al.appendAccount(
                new Account("tmp2", 0)
            );

        System.out.println(success);
    }
}