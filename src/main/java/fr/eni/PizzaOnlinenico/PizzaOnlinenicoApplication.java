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
