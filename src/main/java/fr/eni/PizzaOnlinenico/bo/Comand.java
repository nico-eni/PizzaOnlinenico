package fr.eni.PizzaOnlinenico.bo;



import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Comand {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDateTime date;
	private Double total;
	
	
	@ManyToMany (mappedBy = "comands")
	List<Pizza> pizza = new ArrayList<>();


	public Comand(LocalDateTime date) {
		this.date = date;
	}


    public void addPizza(Pizza pizza) {
		this.pizza.add(pizza);
    }

    public List<Pizza> getPizzas() {
		return pizza;
    }
}
