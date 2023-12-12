package fr.eni.PizzaOnlinenico.dal;

import fr.eni.PizzaOnlinenico.bo.Cheese;
import org.springframework.data.repository.CrudRepository;

public interface CheeseDAO extends CrudRepository<Cheese, Integer> {
}
