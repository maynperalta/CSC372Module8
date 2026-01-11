package main;

import java.util.*;

public class Inventory {
	ArrayList<Book> bookInventory = new ArrayList<Book>();
	ArrayList<Book> borrowedBooks = new ArrayList<Book>();
// Add book to library 	
	public void addBook(Book book) {
		bookInventory.add(book);
		System.out.println("Book added to library inventory.");
	}
// Borrow book from library	
	public void borrowBook(int id) {
		for (Book book : bookInventory) {
			if (book.getId() == id) {
				bookInventory.remove(book);
				borrowedBooks.add(book);
				System.out.println("Book ID: " + id + " borrowed.");
				return;
			}
		}
		System.out.println("Book ID: " + id + " not in library or may be borrowed.");
	}
// Return book to library	
	public void returnBook(int id) {
		for (Book book : borrowedBooks) {
			if (book.getId() == id) {
				borrowedBooks.remove(book);
				bookInventory.add(book);
				System.out.println("Book ID: " + id + " returned to library.");
				return;
			}
		}
		System.out.println("Book ID: " + id + " hasn't been borrowed.");
	}
// Display all books currently in library inventory	
	public void printAll() {
		if (bookInventory.isEmpty()) {
			System.out.println("Library inventory appears to be empty.");
			return;
		}		
		for (Book book : bookInventory) {
			book.printBookInfo();
		}
	}
// Search for a book by title	
	public void searchBookTitle(String title) {
		boolean inInventory = false;
		
		for (Book book : bookInventory) {
			if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
				book.printBookInfo();
				inInventory = true;
			}
		}
		if (!inInventory) {
			System.out.println("Book not found in library.");
		}
	}
}
