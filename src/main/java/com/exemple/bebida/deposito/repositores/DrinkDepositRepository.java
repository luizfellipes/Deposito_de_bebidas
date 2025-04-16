package com.exemple.bebida.deposito.repositores;

import com.exemple.bebida.deposito.models.entities.DrinkDeposit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository public interface DrinkDepositRepository extends JpaRepository<DrinkDeposit, Integer> {
}
