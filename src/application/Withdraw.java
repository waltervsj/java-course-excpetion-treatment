package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.WithdrawException;

public class Withdraw {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter account data");
		
		try {
			System.out.print("Number: ");
			Integer number = sc.nextInt();
			
			System.out.print("Holder: ");
			String holder = sc.nextLine();
			sc.nextLine();
			System.out.print("Initial balance: ");
			Double initialBalance = sc.nextDouble();
			
			System.out.print("Withdraw limit: ");
			Double withdrawLimit = sc.nextDouble();
			
			System.out.print("\nEnter amount for withdraw: ");
			Double amount = sc.nextDouble();
			
			Account account = new Account(number, holder, initialBalance, withdrawLimit);
			
			account.withdraw(amount);
			
			System.out.println("New balance: " + String.format("%.2f", account.getBalance()));
			
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		} catch (WithdrawException e) {
			System.out.println("Withdraw error: " + e.getMessage());
		}
		
		
		
		sc.close();
	}

}
