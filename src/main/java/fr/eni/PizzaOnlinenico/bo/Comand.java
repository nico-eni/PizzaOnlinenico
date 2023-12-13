package fr.eni.PizzaOnlinenico.bo;



import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Comand {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String date;
	private Double total;
	
	
	@OneToMany(mappedBy = "comand")
	List<Pizza> pizza = new ArrayList<>();


	public Comand(String date, Double total) {
		this.date = date;
		this.total = total;
	}
	
	
	
	
}
