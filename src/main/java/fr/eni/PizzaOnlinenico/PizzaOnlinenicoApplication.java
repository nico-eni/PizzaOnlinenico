package fr.eni.PizzaOnlinenico;

import fr.eni.PizzaOnlinenico.bo.BasePizza;
import fr.eni.PizzaOnlinenico.bo.Cheese;
import fr.eni.PizzaOnlinenico.bo.Topping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.eni.PizzaOnlinenico.bll.PizzaManager;
import fr.eni.PizzaOnlinenico.bo.Pizza;
import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class PizzaOnlinenicoApplication {

	@Autowired 
	PizzaManager pizzamanager;

	@PostConstruct
	public void init() {
		/* // Create a BasePizza
		BasePizza basePizza = new BasePizza("Tomate");
		pizzamanager.AddBasePizza(basePizza);

		// Create a Pizza
		Pizza pizza1 = new Pizza("Pepperoni Pizza");
		pizza1.setBasePizza(basePizza);
		pizzamanager.AddPizza(pizza1);

		// Create a Cheese
		Cheese cheese1 = new Cheese("Mozzarella");
		cheese1.setPizza(pizza1);
		pizza1.getCheeses().add(cheese1);
		pizzamanager.AddCheese(cheese1);

		// Create a Topping
		Topping topping1 = new Topping("Pepperoni");
		topping1.setPizza(pizza1);
		pizza1.getToppings().add(topping1);
		pizzamanager.AddTopping(topping1);

		// pour ajouter le prix de la pizza une fois que tous les ingredients sont ajoutés
		pizzamanager.AddPizza(pizza1);*/
	}

	public static void main(String[] args) {
		SpringApplication.run(PizzaOnlinenicoApplication.class, args);
	}

}
