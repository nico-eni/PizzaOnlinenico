package fr.eni.PizzaOnlinenico.dal;

import fr.eni.PizzaOnlinenico.bo.Topping;
import org.springframework.data.repository.CrudRepository;

public interface ToppingDAO extends CrudRepository<Topping, Integer> {
}
