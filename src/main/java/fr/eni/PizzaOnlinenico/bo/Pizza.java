package fr.eni.PizzaOnlinenico.bo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Pizza {
	
	@Id
	@GeneratedValue
	private Integer idPizza;
	private String name;
	private double price;
	
	public Pizza(String name, double price) {
		super();
		this.name = name;
		this.price = price;
	}
	
	
}
