package fr.eni.PizzaOnlinenico.bll;

import fr.eni.PizzaOnlinenico.bo.BasePizza;
import fr.eni.PizzaOnlinenico.bo.Cheese;
import fr.eni.PizzaOnlinenico.bo.Comand;
import fr.eni.PizzaOnlinenico.bo.Topping;
import fr.eni.PizzaOnlinenico.dal.BasePizzaDAO;
import fr.eni.PizzaOnlinenico.dal.CheeseDAO;
import fr.eni.PizzaOnlinenico.dal.ComandDAO;
import fr.eni.PizzaOnlinenico.dal.ToppingDAO;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.eni.PizzaOnlinenico.bo.Pizza;
import fr.eni.PizzaOnlinenico.dal.PizzaDAO;

import java.util.List;

/**
 * Classe de gestion des pizzas. Cette classe permet de gérer les opérations
 * liées aux pizzas telles que l'ajout d'une pizza, d'une base, d'un fromage et
 * d'une garniture.
 */

@Service
public class PizzaManagerImpl implements PizzaManager {

	@Autowired
	private PizzaDAO pizzadao;
	@Autowired
	private BasePizzaDAO basepizzadao;
	@Autowired
	private CheeseDAO cheesedao;
	@Autowired
	private ToppingDAO toppingdao;
	@Autowired
	private ComandDAO comanddao;

	/**
	 * Ajoute une pizza à la base de données. Cette méthode calcule également le
	 * prix de la pizza avant de l'enregistrer.
	 *
	 * @param pizza L'objet Pizza à ajouter.
	 */
	@Override
	public void AddPizza(Pizza pizza) {
		double price = calculatePrice(pizza);
		pizza.setPrice(price);
		pizzadao.save(pizza);
	}

	/**
	 * Calcule le prix d'une pizza. Le prix est déterminé en fonction de la base, du
	 * nombre de fromages et de garnitures.
	 *
	 * @param pizza L'objet Pizza pour lequel le prix est calculé.
	 * @return Le prix calculé de la pizza.
	 */

	private double calculatePrice(Pizza pizza) {
		double basePrice = pizza.getBasePizza().equals("Tomate") ? 5 : 6;
		double cheesePrice = pizza.getCheeses().size();
		double toppingPrice = pizza.getToppings().size();
		return basePrice + cheesePrice + toppingPrice;
	}

	/**
	 * Ajoute une base de pizza à la base de données.
	 *
	 * @param basePizza L'objet BasePizza à ajouter.
	 */

	@Override
	public void AddBasePizza(BasePizza basePizza) {
		basepizzadao.save(basePizza);
	}

	/**
	 * Ajoute un fromage à la base de données.
	 *
	 * @param cheese L'objet Cheese à ajouter.
	 */

	@Override
	public void AddCheese(Cheese cheese) {
		cheesedao.save(cheese);
	}

	/**
	 * Ajoute une garniture à la base de données.
	 *
	 * @param topping L'objet Topping à ajouter.
	 */
	@Override
	public void AddTopping(Topping topping) {
		toppingdao.save(topping);
	}

	/**
	 * Récupère toutes les pizzas de la base de données.
	 *
	 * @return La liste des pizzas.
	 */
	@Override
	public List<Pizza> getAllPizzas() {
		return (List<Pizza>) pizzadao.findAll();
	}
}
