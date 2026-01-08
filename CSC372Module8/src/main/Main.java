package main;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		int userChoice = scnr.nextInt();
		
		System.out.println("Welcome to the library program. Please make a selection: "
				+ "1. Add Book"
				+ "2. Borrow Book"
				+ "3. Return Book"
				+ "4. Print All Books"
				+ "5. Search Book By Title"
				+ "6. Exit");
		
		switch(userChoice) {
		case 1:
			//TODO Enter addBook method
		case 2:
			//TODO Enter borrowBook method
		case 3:
			//TODO enter returnBook method
		case 4:
			//TODO enter printAll method
		case 5:
			//TODO enter searchByTitle method
		case 6:
			System.out.println("Exiting program. Goodbye.");
			break;
		default: 
			System.out.println("Please make a valid selection (1 - 6).");
		}
		scnr.close();
	}
}
