package com.exemple.bebida.deposito.models.entities;

import com.exemple.bebida.deposito.models.enuns.DrinkType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Configuration
public class BeverageWarehouseConfig implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Value("${max-alcoholic-capacity}")
    private Double MAX_ALCOHOLIC_CAPACITY;
    @Value("${max-nonalcoholic-capacity}")
    private Double MAX_NONALCOHOLIC_CAPACITY;
    @Value("${drink-can-be-together}")
    private boolean DRINK_CAN_BE_TOGETHER;
    @Value("${permit-section}")
    private List<String> PERMIT_SECTION;

    public BeverageWarehouseConfig() {
    }

    public BeverageWarehouseConfig(Integer id, Double MAX_ALCOHOLIC_CAPACITY, Double MAX_NONALCOHOLIC_CAPACITY, boolean DRINK_CAN_BE_TOGETHER, List<String> PERMIT_SECTION) {
        this.id = id;
        this.MAX_ALCOHOLIC_CAPACITY = MAX_ALCOHOLIC_CAPACITY;
        this.MAX_NONALCOHOLIC_CAPACITY = MAX_NONALCOHOLIC_CAPACITY;
        this.DRINK_CAN_BE_TOGETHER = DRINK_CAN_BE_TOGETHER;
        this.PERMIT_SECTION = PERMIT_SECTION;
    }

    public Integer getId() {
        return id;
    }

    public Double getMAX_ALCOHOLIC_CAPACITY() {
        return MAX_ALCOHOLIC_CAPACITY;
    }

    public Double getMAX_NONALCOHOLIC_CAPACITY() {
        return MAX_NONALCOHOLIC_CAPACITY;
    }

    public boolean isDRINK_CAN_BE_TOGETHER() {
        return DRINK_CAN_BE_TOGETHER;
    }

    public List<String> getPERMIT_SECTION() {
        return PERMIT_SECTION;
    }

    public Double maxCapacity(DrinkType drinkType) {
        return DrinkType.ALCOHOLIC.equals(drinkType) ? this.MAX_ALCOHOLIC_CAPACITY : this.MAX_NONALCOHOLIC_CAPACITY;
    }
}
