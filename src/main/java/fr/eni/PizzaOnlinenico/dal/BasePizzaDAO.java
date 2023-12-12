package fr.eni.PizzaOnlinenico.dal;

import fr.eni.PizzaOnlinenico.bo.BasePizza;
import org.springframework.data.repository.CrudRepository;

public interface BasePizzaDAO extends CrudRepository<BasePizza, Integer>{
}
