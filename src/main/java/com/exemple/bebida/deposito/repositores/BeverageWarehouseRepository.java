package com.exemple.bebida.deposito.repositores;

import com.exemple.bebida.deposito.models.entities.BeverageWarehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BeverageWarehouseRepository extends JpaRepository<BeverageWarehouse, Integer> {
    List<BeverageWarehouse> findBySectionOrderByIdDesc(String section);
}
