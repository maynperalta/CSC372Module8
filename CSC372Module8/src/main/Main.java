package main;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		Inventory bookInventory = new Inventory();
		int userChoice = 0;
// Switch statement menu with try/catch block for error handling		
		while (userChoice != 6) {
			try {
				System.out.println("Welcome to the library program. Please make a selection: ");
				System.out.println("1. Add Book");
				System.out.println("2. Borrow Book");
				System.out.println("3. Return Book");
				System.out.println("4. Print All Books");
				System.out.println("5. Search Book By Title");
				System.out.println("6. Exit");
				
				userChoice = scnr.nextInt();
				scnr.nextLine();
		
				switch(userChoice) {
					case 1:
						System.out.println("Enter book ID: ");
						int id = scnr.nextInt();
						scnr.nextLine();
						
						System.out.println("Enter book title: ");
						String title = scnr.nextLine();
						
						System.out.println("Enter book author: ");
						String author = scnr.nextLine();
						
						System.out.println("Enter book ISBN: ");
						String isbn = scnr.nextLine();
						
						System.out.println("Enter number of pages: ");
						int pages = scnr.nextInt();
						
						bookInventory.addBook(new Book(id, title, author, isbn, pages));
						break;
					case 2:
						System.out.println("Enter ID of book to borrow: ");
						bookInventory.borrowBook(scnr.nextInt());
						break;
					case 3:
						System.out.println("Enter ID of book to return: ");
						bookInventory.returnBook(scnr.nextInt());
						break;
					case 4:
						bookInventory.printAll();
						break;
					case 5:
						System.out.println("Enter title of book: ");
						bookInventory.searchBookTitle(scnr.nextLine());
						break;
					case 6:
						System.out.println("Exiting program. Goodbye.");
						break;
					default: 
						System.out.println("Please make a valid selection (1 - 6).");
				}
			} catch (Exception e) {
				System.out.println("Invalid input. Please try again.");
				scnr.nextLine();
			}
		}
		scnr.close();
	}
}
