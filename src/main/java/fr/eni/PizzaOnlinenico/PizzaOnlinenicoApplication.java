package fr.eni.PizzaOnlinenico;

import fr.eni.PizzaOnlinenico.bo.BasePizza;
import fr.eni.PizzaOnlinenico.bo.Cheese;
import fr.eni.PizzaOnlinenico.bo.Comand;
import fr.eni.PizzaOnlinenico.bo.Topping;

import java.sql.Date;
import java.text.SimpleDateFormat;
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
		// Create a BasePizza
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

		// pour ajouter le prix de la pizza une fois que tous les ingredients sont
		// ajoutés
//		pizzamanager.AddPizza(pizza1);
//
//		BasePizza basePizza2 = new BasePizza("Crème");
//		pizzamanager.AddBasePizza(basePizza2);
//
//		// Create a Pizza
//		Pizza pizza2 = new Pizza("Crème Pizza");
//		pizza2.setBasePizza(basePizza2);
//		pizzamanager.AddPizza(pizza2);
//
//		// Create a Cheese
//		cheese1.setPizza(pizza2);
//		pizza2.getCheeses().add(cheese1);
//		pizzamanager.AddCheese(cheese1);
//
//		// Create a Topping
//		topping1.setPizza(pizza2);
//		pizza2.getToppings().add(topping1);
//		pizzamanager.AddTopping(topping1);
//
//		// pour ajouter le prix de la pizza une fois que tous les ingredients sont
//		// ajoutés
//		pizzamanager.AddPizza(pizza2);
//
//		/**
//		 * Partie Mélissa
//		 */
//
//		// Création d'une commande
//		Comand comand1 = new Comand("12/12/2023", 28.00);
//		List<Pizza> pizzaList = comand1.getPizza();
//		pizzaList.add(pizza1);
//		pizzaList.add(pizza2);
//		pizzaList.forEach(n -> System.out.println(n.getName()));
//		pizzamanager.AddComand(comand1);
//
//		System.out.println(pizza1.getName());
//		System.out.println(comand1.getDate());
//
	}
	
//	model.addAttribute("listComand", comanddao.findAll());	
//	return "comand";

	
//	Comand comand2 = new Comand("12/12/2023",28.00);		
//	List<Pizza> pizzaList = comand2.getPizza();
//	pizzaList.add(pizza2);
////	pizzaList.forEach(n -> System.out.println(n.getName()));
//	pizzamanager.AddComand(comand);

	public static void main(String[] args) {
		SpringApplication.run(PizzaOnlinenicoApplication.class, args);
	}

}
