package com.exemple.bebida.deposito.models.entities;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "TB_DRINK_DEPOSIT")
public class DrinkDeposit implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public DrinkDeposit(Integer id) {
        this.id = id;
    }



}
