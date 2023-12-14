package fr.eni.PizzaOnlinenico.ihm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import fr.eni.PizzaOnlinenico.bll.CustomerManager;

@Controller
public class ConnexionController {

	@Autowired
	CustomerManager customermanager;

//	@GetMapping("/connexion")
//	public String pageConnexion() {
//		return "connexion";
//	}
	
	@GetMapping("/connexion")
	public String pageConnexion() {
		return "connexion";
	}

}
