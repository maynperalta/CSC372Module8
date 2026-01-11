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
		if (bookInventory.isEmpty() && borrowedBooks.isEmpty()) {
			System.out.println("Library and borrowed book list appear to be empty.");
			return;
		}		
		ArrayList<Book> allBooks = new ArrayList<>();
		allBooks.addAll(bookInventory);
		allBooks.addAll(borrowedBooks);
		
		Collections.sort(allBooks);
		System.out.println("\nLibrary Books: ");
		System.out.printf("%-5s | %-30s | %-30s | %-20s | %-5s | %-10s\n", 
				"ID", "Title", "Author", "ISBN", "Pages", "Status");
		System.out.println("----------------------------------------------");
		
		for (Book book : allBooks) {
			String status = borrowedBooks.contains(book) ? "Borrowed" : "Available";
			System.out.printf("%-5s | %-30s | %-30s | %-20s | %-5s | %-10s\n",
					book.getId(), book.getTitle(), book.getAuthor(), book.getIsbn(), book.getPages(), status);
		}
	}
// Search for a book by title	
	public void searchBookTitle(String title) {
		boolean inInventory = false;
		System.out.println("\nSearch Results: ");
		System.out.printf("%-5s | %-30s | %-30s | %-20s | %-5s | %-10s\n", 
				"ID", "Title", "Author", "ISBN", "Pages", "Status");
		System.out.println("----------------------------------------------");
		
		for (Book book : bookInventory) {
			if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
				System.out.printf("%-5s | %-30s | %-30s | %-20s | %-5s | %-10s\n",
						book.getId(), book.getTitle(), book.getAuthor(), book.getIsbn(), book.getPages(), "Available");
				inInventory = true;
			}
		}
		for (Book book : borrowedBooks) {
			if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
				System.out.printf("%-5s | %-30s | %-30s | %-20s | %-5s | %-10s\n",
						book.getId(), book.getTitle(), book.getAuthor(), book.getIsbn(), book.getPages(), "Borrowed");
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
