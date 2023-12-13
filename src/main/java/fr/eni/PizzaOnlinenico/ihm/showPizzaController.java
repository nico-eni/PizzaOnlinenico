package fr.eni.PizzaOnlinenico.ihm;

import fr.eni.PizzaOnlinenico.bll.PizzaManager;
import fr.eni.PizzaOnlinenico.bo.Pizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class showPizzaController {



        @Autowired
        PizzaManager pizzaManager;

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

