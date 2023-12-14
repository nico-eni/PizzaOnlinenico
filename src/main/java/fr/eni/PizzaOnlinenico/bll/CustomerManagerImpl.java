package fr.eni.PizzaOnlinenico.bll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.eni.PizzaOnlinenico.bo.Customer;
import fr.eni.PizzaOnlinenico.dal.CustomerDAO;

@Service
public class CustomerManagerImpl implements CustomerManager{

	@Autowired
	private CustomerDAO customerdao;

	@Override
	public void AddCustomer(Customer customer) {
		customerdao.save(customer);
		
	}

	/**
	 * Retourne la liste des clients enregistrés
	 */
	@Override
	public List<Customer> getAllCustomers() {
		return (List<Customer>) customerdao.findAll();
	}
	
	

}
