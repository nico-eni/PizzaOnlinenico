package fr.eni.PizzaOnlinenico.dal;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fr.eni.PizzaOnlinenico.bo.Comand;
import org.springframework.data.repository.query.Param;

public interface ComandDAO extends CrudRepository<Comand, Integer> {
        @Query("SELECT c FROM Comand c JOIN c.pizza p WHERE p.idPizza =:pizzaId ORDER BY c.date DESC")
        Comand findCurrentComand(@Param("pizzaId") Long pizzaId);
}


