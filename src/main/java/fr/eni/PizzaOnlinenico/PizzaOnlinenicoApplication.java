package fr.eni.PizzaOnlinenico;

import fr.eni.PizzaOnlinenico.bo.BasePizza;
import fr.eni.PizzaOnlinenico.bo.Cheese;
import fr.eni.PizzaOnlinenico.bo.Comand;
import fr.eni.PizzaOnlinenico.bo.Topping;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.eni.PizzaOnlinenico.bll.PizzaManager;
import fr.eni.PizzaOnlinenico.bo.Pizza;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;

@SpringBootApplication
public class PizzaOnlinenicoApplication {

	@Autowired
	PizzaManager pizzamanager;

	@PostConstruct
	@Transactional
	public void init() {
		/*
		// Create a BasePizza
		BasePizza basePizza = new BasePizza("Tomate");
		pizzamanager.AddBasePizza(basePizza);

		// Create a Pizza
		Pizza pizza1 = new Pizza("Pepperoni Pizza", "pepperoni.jpg");
		pizza1.setBasePizza(basePizza);
		pizzamanager.AddPizza(pizza1);

		// Create a Topping
		Topping topping1 = new Topping("Pepperoni");
		topping1.setPizza(pizza1);
		pizza1.getToppings().add(topping1);
		pizzamanager.AddTopping(topping1);

		// Create a Cheese
		Cheese cheese1 = new Cheese("Mozzarella");
		cheese1.setPizza(pizza1);
		pizza1.getCheeses().add(cheese1);
		pizzamanager.AddCheese(cheese1);

		// Create a Comand
		Comand comand1 = new Comand(LocalDateTime.now());
		comand1.getPizza().add(pizza1);
		pizzamanager.AddComand(comand1);

		// Establish the many-to-many relationship
		pizza1.getComands().add(comand1);
		pizzamanager.AddPizza(pizza1);
		System.out.println("pizza Id is here brah :::: " + pizza1.getIdPizza());

		System.out.println("**************************************************");
		pizzamanager.printPizzaAndComandDetails(1L); */
	}

	public static void main(String[] args) {
		SpringApplication.run(PizzaOnlinenicoApplication.class, args);
	}
}





