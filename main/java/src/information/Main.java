package information;

import banking.Account;
import banking.Bank;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Bank bank = new Bank();
        while(true){
            System.out.println("Options");
            System.out.println("1. Add a bank account");
            System.out.println("2. Remove a bank account");
            System.out.println("3. Search for a bank account");
            System.out.println("4. Display accounts");
            System.out.println("5. Exit");
            System.out.println("Enter your choice: ");
            try{
                String choiceInput = input.nextLine();
                int choice = Integer.parseInt(choiceInput);


                switch(choice){
                    case 1:
                        System.out.println("Enter the account number: ");
                        String accountNumberInput = input.nextLine();
                        int accountNumber = Integer.parseInt(accountNumberInput);

                        System.out.println("Enter the name of the bank account holder: ");
                        String accountHolderName = input.nextLine();

                        System.out.println("Enter the balance of the account: ");
                        String balanceInput = input.nextLine();
                        double balance = Double.parseDouble(balanceInput);

                        System.out.println("Enter the account type: ");
                        String accountType = input.nextLine();

                        bank.addAccount(accountNumber, accountHolderName, balance, accountType);

                        break;


                    case 2:
                        System.out.println("Enter the account number to remove. *Enter the NUMBER. ");
                        String accountToRemoveInput = input.nextLine();
                        int accountToRemove = Integer.parseInt(accountToRemoveInput);

                        bank.removeAccount(accountToRemove);

                        break;

                    case 3:
                        System.out.println("Enter the account holder name to search: ");
                        String query = input.nextLine();
                        Account foundAccount = bank.searchAccount(query);
                        if(foundAccount != null){
                            System.out.println("Found Account: " + foundAccount);
                        }else {
                            System.out.println("Account not found.");
                        }
                        break;
                    case 4:
                        bank.displayAccount();
                        break;

                    case 5:
                        System.out.println("Exiting the program.");
                        System.exit(0);

                    default:
                        System.out.println("Invalid choice. Please choose a valid number.");
                        break;
                }



            }catch (NumberFormatException e){
                System.out.println("Invalid format. Please start from the beginning and enter the valid number!");
            }

        }


    }
}
