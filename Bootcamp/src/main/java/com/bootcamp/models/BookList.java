package com.bootcamp.models;

import java.text.SimpleDateFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="book_list")
public class BookList {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "booklist_id")
	private int id;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "book_status")
	private String bookStatus;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "isbn")
	private String isbn;
	
	@Column(name = "author")
	private String author;
	
	@Column(name = "return_date")
	private long return_date;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getBookStatus() {
		return bookStatus;
	}

	public void setBookStatus(String bookStatus) {
		this.bookStatus = bookStatus;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getReturn_date() {
		return new SimpleDateFormat("MM-dd-yyyy").format(return_date);
	}

	public void setReturn_date(int return_date) {
		this.return_date = return_date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	
	
}
