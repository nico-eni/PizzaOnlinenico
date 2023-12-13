package fr.eni.PizzaOnlinenico.ihm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
}
