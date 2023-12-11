package fr.eni.PizzaOnlinenico;

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
		Pizza pizza1 = new Pizza("napolitaine", 15);
		pizzamanager.ajouterUnePizza(pizza1);
	}

	public static void main(String[] args) {
		SpringApplication.run(PizzaOnlinenicoApplication.class, args);
	}

}
