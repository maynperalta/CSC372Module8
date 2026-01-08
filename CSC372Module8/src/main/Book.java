package main;

public class Book {
	private int id;
	private String title;
	private String author;
	private String ISBN;
	private int pages;
	private boolean borrowed;
	
	Book(int id, String title, String author, String ISBN, int pages, boolean borrowed) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.ISBN = ISBN;
		this.pages = pages;
		this.borrowed = borrowed;
	}
	public void setId(int newId) {
		this.id = newId;
	}
	public void setTitle(String newTitle) {
		this.title = newTitle;
	}
	public void setAuthor(String newAuthor) {
		this.author = newAuthor;
	}
	public void setISBN(String newISBN) {
		this.ISBN = newISBN;
	}
	public void setPages(int newPages) {
		this.pages = newPages;
	}
	public void setBorrowed(boolean isBorrowed) {
		this.borrowed = isBorrowed;
	}
	public int getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public String getAuthor() {
		return author;
	}
	public String getISBN() {
		return ISBN;
	}
	public int getPages() {
		return pages;
	}
	public boolean getBorrowed() {
		return borrowed;
	}
	public toString printBookInfo() {
		return getId(), getTitle(), getAuthor(), getISBN(), getPages(), getBorrowed();
	}
}
