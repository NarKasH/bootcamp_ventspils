package com.bootcamp.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Books {
	
	@NotEmpty(message="Should not be empty")
	@Id
	@Column(name = "title")
	private String title;
	
	@NotEmpty
	@Size(min=13,max=13,message="Must be 13 digits")
	@Column(name = "isbn")
	private String isbn;
	
	@NotEmpty(message="Should not be empty")
	@Column(name = "author")
	private String author;
	
	@Column(name = "book_condition")
	private String condition;
	
	@Min(1)
	@Max(9999)
	@Column(name = "year")
	private Integer year;
	
	@Column(name = "rating")
	private float rating;
	
	@NotEmpty(message="Should not be empty")
	@Column(name = "pic_url")
	private String pic_url;

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

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public int getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public String getPic_url() {
		return pic_url;
	}

	public void setPic_url(String pic_url) {
		this.pic_url = pic_url;
	}

}
