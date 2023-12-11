package fr.eni.PizzaOnlinenico.bll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.eni.PizzaOnlinenico.bo.Pizza;
import fr.eni.PizzaOnlinenico.dal.PizzaDAO;

@Service
public class PizzaManagerImpl implements PizzaManager{

	@Autowired
	PizzaDAO pizzadao;

	@Override
	public void ajouterUnePizza(Pizza pizza) {
		pizzadao.save(pizza);
		
	}
}
