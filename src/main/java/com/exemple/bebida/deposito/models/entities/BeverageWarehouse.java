package com.exemple.bebida.deposito.models.entities;

import com.exemple.bebida.deposito.models.enuns.DrinkType;
import com.exemple.bebida.deposito.models.enuns.MovimentType;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "TB_BEVERAGE_WAREHOUSE")
public class BeverageWarehouse implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDateTime data;
    private String responsible;
    private String section;
    private MovimentType movimentType;
    private DrinkType drinkType;
    private Double volume;
    private String drinkName;
    private Double totalVolumeInSection;

}
