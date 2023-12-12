package fr.eni.PizzaOnlinenico.bo;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Generated
@NoArgsConstructor
@Entity
public class BasePizza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "basePizza")
    private List<Pizza> pizzas;

    public BasePizza(String name) {
        this.name = name;
    }

}
