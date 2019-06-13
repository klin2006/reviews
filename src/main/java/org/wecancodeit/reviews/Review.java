package org.wecancodeit.reviews;

public class Review {
	private long id;
	private String title;
	private String author;
	String description;
	private double rating;
	private String url;
	private String category;

	public Review(Long id, String title, String author, String description, double rating, String url, String category) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.description = description;
		this.rating = rating;
		this.url = url;
		this.category = category;

	}
	
	public long getId() {
		return id;
		
	}

	public String getTitle() {
		return title;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public String getDescription() {
		return description;
	}
	
	public double getRating() {
		return rating;
	}
	
	public String getUrl() {
		return url;
	}
	
	public String getCategory() {
		return category;
			
		}
	}


