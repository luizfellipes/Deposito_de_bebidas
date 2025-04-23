package com.exemple.bebida.deposito.models.dto;

import com.exemple.bebida.deposito.models.enuns.DrinkType;
import com.exemple.bebida.deposito.models.enuns.MovimentType;

import java.time.LocalDateTime;

public record BeverageWarehouseDTO(
         Integer id,
         LocalDateTime data,
         String responsible,
         String section,
         MovimentType movimentType,
         DrinkType drinkType,
         Double volume,
         String drinkName
) {
}
