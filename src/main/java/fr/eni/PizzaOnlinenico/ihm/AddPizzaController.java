package fr.eni.PizzaOnlinenico.ihm;

import fr.eni.PizzaOnlinenico.bo.*;
import fr.eni.PizzaOnlinenico.bll.PizzaManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class AddPizzaController{

    @Autowired
    PizzaManager pizzaManager;


    /**
     * cette méthode permet d'afficher le formulaire d'ajout d'une pizza
     * @return le nom de la page html
     */
    @GetMapping("/submit-pizza")
    public String showForm() {
            return "addPizzaForm";
        }

    /**
     * cette méthode permet d'afficher la liste des pizzas
      * @return
     */
    @GetMapping("/")
    public String home() {
        return "showPizza";
    }


    /**
     * cette méthode permet d'ajouter une pizza
     * @param pizza_name
     * @param image_url
     * @param base
     * @param cheese
     * @param ingredient
     * @param redirectAttributes
     * @return le nom de la page html
     */

    @PostMapping("/submit-pizza")
    public String submitPizza(@RequestParam String pizza_name,@RequestParam String image_url ,@RequestParam String base, @RequestParam(required=false) List<String> cheese, @RequestParam(required=false) List<String> ingredient, RedirectAttributes redirectAttributes) {
        // Create a BasePizza
        BasePizza basePizza = new BasePizza(base);
        pizzaManager.AddBasePizza(basePizza);

        // Create a Pizza
        Pizza pizza = new Pizza(pizza_name , image_url);
        pizza.setBasePizza(basePizza);
        pizzaManager.AddPizza(pizza);

        // Add Cheeses
        if (cheese != null) {
            for (String cheeseName : cheese) {
                Cheese newCheese = new Cheese(cheeseName);
                newCheese.setPizza(pizza);
                pizza.getCheeses().add(newCheese);
                pizzaManager.AddCheese(newCheese);
            }
        }

        // Check if the user selected at least 3 toppings
        if (ingredient == null || ingredient.size() < 3) {
            redirectAttributes.addFlashAttribute("error", "vous devez sélectionner au moins 3 ingrédients ! ");
            return "redirect:/submit-pizza";
        }

        // Add Toppings
        for (String toppingName : ingredient) {
            Topping topping = new Topping(toppingName);
            topping.setPizza(pizza);
            pizza.getToppings().add(topping);
            pizzaManager.AddTopping(topping);
        }

        // Add command with date now
        Comand comand = new Comand(LocalDateTime.now());
        comand.getPizza().add(pizza);
        pizzaManager.AddComand(comand);

        // Establish the many-to-many relationship
        pizza.getComands().add(comand);

        // Add the price of the pizza once all the ingredients are added
        pizzaManager.AddPizza(pizza);

        // Redirect to the add-pizzas-to-cart URL with the ID of the newly created pizza
        return "redirect:/add-pizzas-to-cart/" + pizza.getIdPizza();
    }

}

