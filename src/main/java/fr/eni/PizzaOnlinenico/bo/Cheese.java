package fr.eni.PizzaOnlinenico.bo;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

@Data
@Generated
@NoArgsConstructor
@Entity
public class Cheese {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne
    private Pizza pizza;

    public Cheese(String name) {
        this.name = name;
    }
}
