package fr.eni.PizzaOnlinenico.bll;



import fr.eni.PizzaOnlinenico.bo.BasePizza;
import fr.eni.PizzaOnlinenico.bo.Cheese;
import fr.eni.PizzaOnlinenico.bo.Comand;
import fr.eni.PizzaOnlinenico.bo.Pizza;
import fr.eni.PizzaOnlinenico.bo.Topping;

import java.util.List;

public interface PizzaManager {
		void AddPizza(Pizza pizza);
		void AddBasePizza(BasePizza basePizza);
		void AddCheese(Cheese cheese);
		void AddTopping(Topping topping);
		List<Pizza> getAllPizzas();

}
