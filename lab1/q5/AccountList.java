package lab1.q5;

import lab1.q4.Account;

public class AccountList {

    private Account[] accounts;
    private int count;

    public AccountList(int maxSize) {

        accounts = new Account[maxSize];
        count = 0;
    }

    public boolean appendAccount(Account account) {

        if (count < accounts.length) {

            accounts[count] = account;
            count++;

            return true;
        }

        return false;
    }

    public Account getAccount(int idx) {

        if (idx >= 0 && idx < count) {
            return accounts[idx];
        }

        System.out.println(
            "Input index exceeds the number of appended elements"
        );

        return null;
    }
}
