package fr.eni.PizzaOnlinenico.ihm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.eni.PizzaOnlinenico.bll.CustomerManager;
import fr.eni.PizzaOnlinenico.bo.Customer;
import jakarta.validation.Valid;

@Controller
public class RegistrationController {

	@Autowired
	CustomerManager customerManager;

	/*
	 * Affichage de la page d'accueil
	 */
	@GetMapping("/home")
	public String pageHome() {
		return "home";
	}
	
	
	/*
	 * Affichage de la page d'inscription d'un client
	 */
//	@GetMapping("/registration")
//	public String pageRegistration() {
//		return "registration";
//	}

	/**
	 * Affichage de la liste des clients
	 * 
	 * @param personne
	 * @param model
	 * @return
	 */
	@GetMapping("/registration")
	public String index(Customer customer, Model model) {
//		model.addAttribute("lstCustomers", customerManager.getAllCustomers());
		model.addAttribute("customer", new Customer());
		return "registration";
	}

	/**
	 * Permet d'inscrire un nouveau client
	 * 
	 * @param customer
	 * @param errors
	 * @return
	 */
	@PostMapping("/registration")
	public String add(@Valid @ModelAttribute("customer") Customer customer,
			@RequestParam(name = "confirmMdp") String confirmMdp,
//			@RequestParam(name = "robot") String robot,
			BindingResult bindingResult, RedirectAttributes redirectAttributes) {

		
		
		/*
		 * Validation des données saisies
		 */
		if (customer.getUsernameC() == null || customer.getUsernameC().trim().isEmpty()) {
			/**
			 * Ajout d'une erreur personnalisée pour le champs "nom"
			 */
			bindingResult.rejectValue("usernameC", "error.usernameC", "Veuillez saisir votre nom");
		}

		if (customer.getFirstnameC() == null || customer.getFirstnameC().trim().isEmpty()) {
			/**
			 * Ajout d'une erreur personnalisée pour le champs "prénom"
			 */
			bindingResult.rejectValue("firstnameC", "error.firstnameC",
					"Veuillez saisir votre prénom");
		}

		if (customer.getMailC() == null || customer.getMailC().trim().isEmpty()) {
			/**
			 * Ajout d'une erreur personnalisée pour le champs "mail"
			 */
			bindingResult.rejectValue("mailC", "error.mailC", "Veuillez saisir votre mail");
		}

		if (customer.getPhoneC() == null || customer.getPhoneC().trim().isEmpty()) {
			/**
			 * Ajout d'une erreur personnalisée pour le champs "téléphone"
			 */
			bindingResult.rejectValue("phoneC", "error.phoneC",
					"Veuillez saisir votre numéro de téléphone");
		}

		if (customer.getMdpC() == null || customer.getMdpC().trim().isEmpty()) {
			/**
			 * Ajout d'une erreur personnalisée pour le champs "mot de passe"
			 */
			bindingResult.rejectValue("mdpC", "error.mdpC", "Veuillez saisir votre mot de passe");

			/**
			 * TESTER L'EGALITE ENTRE LES DEUX MOTS DE PASSE Ajout d'une erreur
			 * personnalisée
			 */
		} else if (!customer.getMdpC().equals(confirmMdp)) {
			bindingResult.rejectValue("mdpC", "error.mismatch", "Les mots de passe ne correspondent pas");
		}

		/*
		 * Contrôle du champs Adresse
		 */
		if (customer.getAddressC() == null || customer.getAddressC().trim().isEmpty()) {
			/**
			 * Ajout d'une erreur personnalisée pour le champs "adresse"
			 */
			bindingResult.rejectValue("addressC", "error.addressC", "Veuillez saisir votre adresse");
		}

		/**
		 * Contrôle du champs Code Postal
		 */
		if (customer.getPostalCodeC() == null || customer.getPostalCodeC().trim().isEmpty()) {
			/**
			 * Ajout d'une erreur personnalisée pour le champs "Code Postal"
			 */
			bindingResult.rejectValue("postalCodeC", "error.postalCodeC", "Veuillez saisir votre code postal");
		}

		/**
		 * Contrôle du champs Ville
		 */
		if (customer.getCityC() == null || customer.getCityC().trim().isEmpty()) {
			/**
			 * Ajout d'une erreur personnalisée pour le champs "Ville"
			 */
			bindingResult.rejectValue("cityC", "error.cityC", "Veuillez saisir votre ville");
		}

		/**
		 * Vérification des champs non obligatoires Insertion de null s'ils sont vides
		 */

		/**
		 * Champs : Société Etage Bâtiment Ascenceur Interphone Digicode1 Digicode2
		 * Instruction Spéciales
		 * 
		 */
		if (customer.getCompanyC() == null) {
			customer.setCompanyC("null");
		}

		if (customer.getFloor() == null) {
			customer.setFloor("null");
		}
		if (customer.getBuilding() == null) {
			customer.setBuilding("null");
		}
		if (customer.getElevator() == null) {
			customer.setElevator("null");
		}
		if (customer.getIntercom() == null) {
			customer.setIntercom("null");
		}
		if (customer.getDigicode1() == null) {
			customer.setDigicode1("null");
		}
		if (customer.getDigicode2() == null) {
			customer.setDigicode2("null");
		}
		if (customer.getInstructions() == null) {
			customer.setInstructions("null");
		}

		/**
		 * Contrôle si l'utilisateur à coché la case "Je ne suis pas un robot"
		 */	 
//		 boolean robotS = Boolean.parseBoolean(robot);
//		 if (!robotS) {
//		        bindingResult.rejectValue("robot", "error.robot", "Vous devez cocher la case robot.");
//		    }

		/*
		 * S'il y a des erreurs on redirige l'utilisateur sinon on valide le formulaire
		 */
		if (bindingResult.hasErrors()) {
			return "registration";
		} else {
			customerManager.AddCustomer(customer);
			redirectAttributes.addFlashAttribute("Félicitation ! Vous êtes bien inscrit");

			return "redirect:/home";
		}

	}
}
