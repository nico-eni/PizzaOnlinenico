package fr.eni.PizzaOnlinenico.dal;

import org.springframework.data.repository.CrudRepository;

import fr.eni.PizzaOnlinenico.bo.Comand;

public interface ComandDAO extends CrudRepository<Comand, Integer> {

}
