package fr.eni.PizzaOnlinenico.bo;


import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idC;
	
	/*
	 * Vérification de la civilité
	 */
//	@NotBlank(message = "Veuillez choisir une civilité s'il vous plaît")	
	private String civility;
	
	/*
	 * Vérification du nom
	 */
//	@NotBlank(message = "Veuillez saisir votre nom s'il vous plaît")	
	private String usernameC;
	
	/*
	 * Vérification du prénom 
	 */
//	@NotBlank(message = "Veuillez saisir votre prénom s'il vous plaît")	
	private String firstnameC;
	
	
	
	/*
	 * Vérification du mail
	 */
//	@NotBlank(message = "Veuillez saisir votre adresse mail s'il vous plaît ")	
	private String mailC;
	
	/*
	 * Vérification du numéro de téléphone
	 */
//	@NotBlank(message = "Veuillez saisir votre numéro de téléphone s'il vous plaît")	
	private String phoneC;
	
	
	/*
	 * Vérification du mot de passe
	 */
//	@NotBlank(message = "Veuillez saisir votre mot de passe s'il vous plaît")	
	private String mdpC;
	
	
	
	/*
	 * Vérification de l'adresse
	 */
//	@NotBlank(message = "Veuillez saisir votre adresse s'il vous plaît")	
	private String addressC;
	
	
	/*
	 * Vérification du code postal
	 */
//	@NotBlank(message = "Veuillez saisir votre code postal s'il vous plaît")	
	private String postalCodeC;
	
	/*
	 * Vérification de la ville
	 */
//	@NotBlank(message = "Veuillez saisir votre ville s'il vous plaît")	
	private String cityC;
	
	
	private String companyC;
	private String floor;
	private String building;
	private String elevator;
	private String intercom;
	private String digicode1;
	private String digicode2;
	private String instructions;
	
	


	public Customer(String civility, String usernameC,String firstnameC,  String mailC, String phoneC,
			String mdpC, String addressC, String postalCodeC, String cityC) {
		this.civility = civility;
		this.firstnameC = firstnameC;
		this.usernameC = usernameC;
		this.mailC = mailC;
		this.phoneC = phoneC;
		this.mdpC = mdpC;
		this.addressC = addressC;
		this.postalCodeC = postalCodeC;
		this.cityC = cityC;
	}
	
	

	
	
}
