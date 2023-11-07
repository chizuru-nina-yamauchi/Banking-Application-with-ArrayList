package banking;

import java.util.ArrayList;

public class Bank {
    private ArrayList<Account> accounts;

    public Bank() {
        accounts = new ArrayList<>();
    }
    public void addAccount(int accountNumber, String accountHolderName, double balance, String accountType ){
        for(Account account : accounts){
            if(account.getAccountNumber() == accountNumber){
                account.setBalance(account.getBalance() + balance);
                return;
            }
        }
        Account account = new Account(accountNumber, accountHolderName, balance, accountType);
        accounts.add(account);
    }
    public void removeAccount(Integer accountNumber){
        accounts.removeIf(account ->account.getAccountNumber() == accountNumber);
    }
    public Account searchAccount(String query){
        for(Account account : accounts){
            if(account.getAccountHolderName().equalsIgnoreCase(query)){
                return account;
            }
        }
        return null;
    }
    public void displayAccount(){
        System.out.println("Current Accounts: ");
        for(Account account : accounts){
            System.out.println(account);
        }
    }

    public double totalBankBalance(){
        double totalBalance = 0.0;
        for(int i = 0; i < accounts.size(); i++) {
            Account account = accounts.get(i);
            if(account != null){
                totalBalance += account.getBalance();
            }
        }
        return totalBalance;
    }

}
