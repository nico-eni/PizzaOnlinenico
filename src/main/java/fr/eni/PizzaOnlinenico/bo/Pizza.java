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
	private Long idPizza;
	private String name;
	private Double price;
	private String imageUrl;

	@ManyToOne
	private BasePizza basePizza;

	@OneToMany(mappedBy = "pizza")
	private List<Topping> toppings = new ArrayList<>();

	@OneToMany(mappedBy = "pizza")
	private List<Cheese> cheeses = new ArrayList<>();

	/**
	 * ManyToMany: une pizza peut être commandée par plusieurs commandes
	 * et une commande peut contenir plusieurs pizzas
	 * @JoinTable: permet de définir la table de jointure
	 * joinColumns: permet de définir la colonne de jointure avec la table pizza et la clé primaire
	 * inverseJoinColumns: permet de définir la colonne de jointure avec la table inverse (comand) et la clé étrangère
	 */
	@ManyToMany
	@JoinTable(name = "pizza_comand",
			joinColumns = @JoinColumn(name = "pizza_id"),
			inverseJoinColumns = @JoinColumn(name = "comand_id"))
	private List<Comand> comands = new ArrayList<>();

	public Pizza(String name , String imageUrl) {
		this.name = name;
		this.imageUrl = imageUrl;
	}


	
}
