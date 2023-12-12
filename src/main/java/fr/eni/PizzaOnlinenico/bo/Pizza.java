package fr.eni.PizzaOnlinenico.bo;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
public class Pizza {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPizza;
	private String name;
	private Double price;

	@ManyToOne
	private BasePizza basePizza;

	@OneToMany(mappedBy = "pizza")
	private List<Topping> toppings = new ArrayList<>();

	@OneToMany(mappedBy = "pizza")
	private List<Cheese> cheeses = new ArrayList<>();


	public Pizza(String name) {
		this.name = name;
	}


	
}
