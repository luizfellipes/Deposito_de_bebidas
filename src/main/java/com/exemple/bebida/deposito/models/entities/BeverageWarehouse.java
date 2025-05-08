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
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private LocalDateTime data;
    private String responsible;
    private String section;
    private MovimentType movimentType;
    private DrinkType drinkType;
    private String drinkName;
    private Double volume;
    private Double totalVolumeInSection;

    public BeverageWarehouse() {
    }

    public BeverageWarehouse(Integer id, LocalDateTime data, String responsible, String section, MovimentType movimentType, DrinkType drinkType, String drinkName, Double volume) {
        this.id = id;
        this.data = data;
        this.responsible = responsible;
        this.section = section;
        this.movimentType = movimentType;
        this.drinkType = drinkType;
        this.drinkName = drinkName;
        this.totalVolumeInSection = 0.0;
        validNegativeNumbers(volume);
    }

    public Integer getId() {
        return id;
    }

    public LocalDateTime getData() {
        return data;
    }

    public String getResponsible() {
        return responsible;
    }

    public String getSection() {
        return section;
    }

    public MovimentType getMovimentType() {
        return movimentType;
    }

    public DrinkType getDrinkType() {
        return drinkType;
    }

    public Double getVolume() {
        return volume;
    }

    public String getDrinkName() {
        return drinkName;
    }

    public Double getTotalVolumeInSection() {
        return totalVolumeInSection;
    }

    //Methods

    private void validNegativeNumbers(Double numbers) {
        if (numbers <= 0) {
            throw new RuntimeException("Negatives numbers are not allowed !");
        } else {
            this.volume = numbers;
        }
    }

    public void totalVolumeInSection(Double volumeInSection) {
        this.totalVolumeInSection = volumeInSection;
    }

}
