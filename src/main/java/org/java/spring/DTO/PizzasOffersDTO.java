package org.java.spring.DTO;

import java.time.LocalDate;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;

public class PizzasOffersDTO {
	
	private int pizza_id;
	
	@Column(length = 64, nullable = false)
	@Length(min = 3, max = 60, message = "title must be between 3 and 60 characters")
	@NotEmpty(message = "title can't be empty")
	private String title;
	private LocalDate startDate;
	private LocalDate endDate;
	
	
	public int getPizza_id() {
		return pizza_id;
	}
	public void setPizza_id(int pizza_id) {
		this.pizza_id = pizza_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	
	@Override
	public String toString() {
		
		return getPizza_id() + " - " + getTitle();
	}
}
