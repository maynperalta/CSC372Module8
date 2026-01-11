package main;

import java.util.*;

public class Inventory {
	private ArrayList<Book> bookInventory = new ArrayList<Book>();
	private ArrayList<Book> borrowedBooks = new ArrayList<Book>();
// Add book to library 	
	public void addBook(Book book) {
		for (Book checkId : bookInventory) {
			if(checkId.getId() == book.getId()) {
				System.out.println("Book ID: " + book.getId() + " already in inventory.");
				return;
			}
		}
		for(Book checkId : borrowedBooks) {
			if(checkId.getId() == book.getId()) {
				System.out.println("Book ID: " + book.getId() + " is currently being borrowed.");
				return;
			}
		}
		bookInventory.add(book);
		System.out.println("Book added to the library.");
	}
// Borrow book from library	with iterator
	public void borrowBook(int id) {
		Iterator<Book> iterator = bookInventory.iterator();
		while (iterator.hasNext()) {
			Book book = iterator.next();
			if (book.getId() == id) {
				iterator.remove();
				borrowedBooks.add(book);
				System.out.println("Book successfully borrowed.");
				return;
			}
		}
// Message if book is being borrowed
		for (Book book : borrowedBooks) {
			if (book.getId() == id) {
				System.out.println("Book ID: " + id + " is currently being borrowed.");
				return;
			}
		}
		System.out.println("Book ID: " + id + " is not in library.");
	}
// Return book to library with iterator
	public void returnBook(int id) {
		Iterator<Book> iterator = borrowedBooks.iterator();
		while (iterator.hasNext()) {
			Book book = iterator.next();
			if (book.getId() == id) {
				iterator.remove();
				bookInventory.add(book);
				System.out.println("Book successfully returned.");
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
		Collections.sort(bookInventory);
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
			System.out.println("No matching book found.");
		}
	}
	
	public static boolean isbnValid(String isbn) {
		if (isbn == null) return false;
		String straightIsbn = isbn.replace("-", "");
		return straightIsbn.matches("\\d{9}[\\dXx]|\\d{13}");
		}
}
