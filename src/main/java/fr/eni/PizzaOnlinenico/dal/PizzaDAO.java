package fr.eni.PizzaOnlinenico.dal;

import org.springframework.data.repository.CrudRepository;
import fr.eni.PizzaOnlinenico.bo.Pizza;

public interface PizzaDAO extends CrudRepository<Pizza, Long>{
}
