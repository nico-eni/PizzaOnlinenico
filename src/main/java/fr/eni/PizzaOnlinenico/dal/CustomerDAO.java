package fr.eni.PizzaOnlinenico.dal;

import org.springframework.data.repository.CrudRepository;

import fr.eni.PizzaOnlinenico.bo.Customer;

public interface CustomerDAO extends CrudRepository<Customer, Long>{

}
