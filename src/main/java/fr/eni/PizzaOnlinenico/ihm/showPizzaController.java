package fr.eni.PizzaOnlinenico.ihm;

import fr.eni.PizzaOnlinenico.bll.PizzaManager;
import fr.eni.PizzaOnlinenico.bo.BasePizza;
import fr.eni.PizzaOnlinenico.bo.Cheese;
import fr.eni.PizzaOnlinenico.bo.Pizza;
import fr.eni.PizzaOnlinenico.bo.Topping;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class showPizzaController {

    @Autowired
    PizzaManager pizzaManager;

    @PostConstruct
    public void init() {
        // List of real pizza names
        List<String> pizzaNames = Arrays.asList("Margherita", "Pepperoni", "BBQ Chicken", "Hawaiian", "Meat Lovers", "Veggie");

        // List of real base names
        List<String> baseNames = Arrays.asList("Thin Crust", "Thick Crust", "Cheese Stuffed Crust", "Gluten Free Crust", "Whole Wheat Crust", "Cauliflower Crust");

        // List of real cheese names
        List<String> cheeseNames = Arrays.asList("Mozzarella", "Cheddar", "Parmesan", "Gorgonzola", "Ricotta", "Provolone");

        // List of real topping names
        List<List<String>> toppingNames = Arrays.asList(
                Arrays.asList("Tomato Sauce", "Mozzarella", "Basil"),
                Arrays.asList("Tomato Sauce", "Mozzarella", "Pepperoni"),
                Arrays.asList("BBQ Sauce", "Mozzarella", "Chicken", "Red Onion"),
                Arrays.asList("Tomato Sauce", "Mozzarella", "Ham", "Pineapple"),
                Arrays.asList("Tomato Sauce", "Mozzarella", "Pepperoni", "Sausage", "Bacon", "Ham"),
                Arrays.asList("Tomato Sauce", "Mozzarella", "Bell Pepper", "Mushroom", "Red Onion", "Black Olives")
        );

        for (int i = 0; i < 6; i++) {
            Pizza pizza = new Pizza(pizzaNames.get(i), "https://images.unsplash.com/photo-1613564834361-9436948817d1?q=80&w=1943&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D" + (i+1));
            BasePizza basePizza = new BasePizza(baseNames.get(i));
            pizza.setBasePizza(basePizza);
            pizzaManager.AddBasePizza(basePizza);
            pizzaManager.AddPizza(pizza);

            Cheese cheese = new Cheese(cheeseNames.get(i));
            cheese.setPizza(pizza);
            pizza.getCheeses().add(cheese);
            pizzaManager.AddCheese(cheese);

            for (String toppingName : toppingNames.get(i)) {
                Topping topping = new Topping(toppingName);
                topping.setPizza(pizza);
                pizza.getToppings().add(topping);
                pizzaManager.AddTopping(topping);
            }
        }
    }

        /**
         * cette méthode permet d'afficher la liste des pizzas
         * @return le nom de la page html
         */
        @GetMapping("/show-pizza")
        public String showPizzas(Model model) {
            List<Pizza> pizzas = pizzaManager.getAllPizzas();
            model.addAttribute("pizzas", pizzas);
            return "showPizza";
        }
    }

