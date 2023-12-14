package fr.eni.PizzaOnlinenico.bll;

import java.util.List;

import fr.eni.PizzaOnlinenico.bo.Customer;


public interface CustomerManager {

	void AddCustomer(Customer customer);

	List<Customer> getAllCustomers();
}
