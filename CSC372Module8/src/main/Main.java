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
				System.out.println("\nWelcome to the library program. Please make a selection: ");
				System.out.println("1. Add Book");
				System.out.println("2. Borrow Book");
				System.out.println("3. Return Book");
				System.out.println("4. Search Book By Title");
				System.out.println("5. Print All Books");				
				System.out.println("6. Exit");
				
				userChoice = scnr.nextInt();
				scnr.nextLine();
		
				switch(userChoice) {
					case 1:
						int id;
						while (true) {
							System.out.println("Enter book ID: ");	
							id = scnr.nextInt();
							scnr.nextLine();
							if(id > 0) break;
							System.out.println("ID must be positive. Please try again");
						}
						
						System.out.println("Enter book title: ");
						String title = scnr.nextLine();
						
						System.out.println("Enter book author: ");
						String author = scnr.nextLine();
						
						String isbn;
						while (true) {
							System.out.println("Enter book ISBN: ");
							isbn = scnr.nextLine();
							if (Inventory.isbnValid(isbn)) break;
							System.out.println("Invalid ISBN. Please enter 10 or 13 digit ISBN.");
						}
						
						int pages;
						while (true) {
							System.out.println("Enter number of pages: ");
							pages = scnr.nextInt();
							scnr.nextLine();
							if (pages > 0) break;
							System.out.println("Number of pages must be positive. Please try again.");
						}
						
						bookInventory.addBook(new Book(id, title, author, isbn, pages));
						break;
						
					case 2:
						System.out.println("Enter ID of book to borrow: ");
						int borrowId = scnr.nextInt();
						scnr.nextLine();
						bookInventory.borrowBook(borrowId);
						break;
					case 3:
						System.out.println("Enter ID of book to return: ");
						int returnId = scnr.nextInt();
						scnr.nextLine();
						bookInventory.returnBook(returnId);
						break;
					case 4:
						System.out.println("Enter title of book: ");
						String seachTitle = scnr.nextLine();
						bookInventory.searchByTitle(seachTitle);
						break;
					case 5:
						bookInventory.printAll();
						break;						
					case 6:
						System.out.println("Exiting program. Goodbye.");
						break;
					default: 
						System.out.println("Please make a valid selection (1 - 6).");
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid input. Please try again.");
				scnr.nextLine();
			} catch (Exception e) {
				System.out.println("An error has occurred: " + e.getMessage());
				scnr.nextLine();
			}
		}
		scnr.close();
	}
}
