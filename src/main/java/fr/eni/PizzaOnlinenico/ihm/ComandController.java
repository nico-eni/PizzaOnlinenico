package fr.eni.PizzaOnlinenico.ihm;

import java.util.List;

import fr.eni.PizzaOnlinenico.bll.PizzaManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.eni.PizzaOnlinenico.bo.Comand;
import fr.eni.PizzaOnlinenico.dal.ComandDAO;
import fr.eni.PizzaOnlinenico.dal.PizzaDAO;

@Controller
@RequestMapping("/PizzaOnline")
public class ComandController {

	@Autowired
	ComandDAO comanddao;

	@Autowired
	PizzaDAO pizzadao;

	@Autowired
	PizzaManager pizzaManager;



	@GetMapping("/test")
	public String test() {
		return "comand";
	}

	@GetMapping("/comand")
	public String panier(Comand comand, Model model) {		
		List<Comand> listComand = (List<Comand>) comanddao.findAll();
		System.out.println("Nombre de commandes : " + listComand.size());
		model.addAttribute("listComand", listComand);
		return "comand";
	}

	@DeleteMapping("/deletePizzaFromCommand/{pizzaId}")
	public ResponseEntity<Void> deletePizzaFromCommand(@PathVariable Long pizzaId) {
		pizzaManager.deletePizzaFromCommand(pizzaId);
		return ResponseEntity.ok().build();
	}
}
