package fr.eni.PizzaOnlinenico.ihm;

import fr.eni.PizzaOnlinenico.bll.PizzaManager;
import fr.eni.PizzaOnlinenico.bo.Comand;
import fr.eni.PizzaOnlinenico.bo.Pizza;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;


@Controller
public class AddPizzaToCart {

    @Autowired
    PizzaManager pizzaManager;

    @Autowired
    private HttpSession httpSession;

    @GetMapping("/add-pizzas-to-cart/{pizzaId}")
    public String addPizzasToCart(@PathVariable Long pizzaId, Model model) {
        Comand comand = (Comand) httpSession.getAttribute("comand");
        if (comand == null) {
            comand = new Comand(LocalDateTime.now());
            httpSession.setAttribute("comand", comand);
        }
        Pizza pizza = pizzaManager.getPizzaById(pizzaId);
        if (pizza != null && !comand.getPizzas().contains(pizza)) {
            comand.addPizza(pizza);
            pizzaManager.AddComand(comand);
        }
        model.addAttribute("comand", comand);
        return "addToCart";
    }
}