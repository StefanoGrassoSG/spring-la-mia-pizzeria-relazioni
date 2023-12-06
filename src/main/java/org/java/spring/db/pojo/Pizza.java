package org.java.spring.db.pojo;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
public class Pizza {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(length = 64, nullable = false, unique = true)
	@Length(min = 3, max = 60, message = "name must be between 3 and 60 characters")
	@NotEmpty(message = "name can't be empty")
	private String name;
	
	@Column(columnDefinition = "TEXT")
	@Length(min = 3, max = 1500, message = "description must be between 3 and 1500 characters")
	@NotEmpty(message = "description can't be empty")
	private String description;
	
	@Column(columnDefinition = "TEXT")
	private String image;
	
	@NotNull(message = "price can't be empty")
	@Min(value = 1, message = "the price must be greater than 0")
	@Max(value = 100, message = "the price must be lower than 100")
	private double price;
	
	public Pizza() {}
	public Pizza(String name, String description, String image, double price) {
		setName(name);
		setDescription(description);
		setImage(image);
		setPrice(price);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		
		return "[" + getId() + "] " + getName() + " - " 
				+ getDescription() + getImage() + " - "
				+ getPrice();
	}
}
