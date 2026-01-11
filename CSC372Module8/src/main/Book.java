package main;

public class Book implements Comparable<Book>{
	private int id;
	private String title;
	private String author;
	private String isbn;
	private int pages;
// Default constructor	
	public Book() {
	}
// Parameterized constructor	
	public Book(int id, String title, String author, String isbn, int pages) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.pages = pages;
	}
// Setters and getters for id	
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
// Setters and getters for title	
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTitle() {
		return title;
	}
// Setters and getters for author	
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getAuthor() {
		return author;
	}
// Setters and getters for ISBN	
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getIsbn() {
		return isbn;
	}
// Setters and getters for number of pages	
	public void setPages(int pages) {
		this.pages = pages;
	}
	public int getPages() {
		return pages;
	}
// Method to print specific book's information
	public void printBookInfo() {
		System.out.printf("%-5d | %-30s | %-30s | %-20s | %-5d\n",
				id, title, author, isbn, pages);
	}
	@Override
	public int compareTo(Book other) {
		return this.title.compareToIgnoreCase(other.title);
	}
}