package com.exemple.bebida.deposito.services;

import com.exemple.bebida.deposito.models.dto.BeverageWarehouseDTO;
import com.exemple.bebida.deposito.models.entities.BeverageWarehouse;
import com.exemple.bebida.deposito.repositores.BeverageWarehouseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
public class BeverageWarehouseService {

    private final BeverageWarehouseRepository repository;


    public BeverageWarehouseService(BeverageWarehouseRepository repository) {
        this.repository = repository;
    }

    public BeverageWarehouse save(BeverageWarehouseDTO beverageWarehouseDTO){
        return Stream.of(convertToModel(beverageWarehouseDTO)).map(repository::save).findFirst().orElseThrow();
    }

    public List<BeverageWarehouse> getAll() {
        return repository.findAll();
    }

    private BeverageWarehouse convertToModel(BeverageWarehouseDTO beverageWarehouseDTO){
       return new BeverageWarehouse(beverageWarehouseDTO.id(), beverageWarehouseDTO.data(), beverageWarehouseDTO.responsible(), beverageWarehouseDTO.section(), beverageWarehouseDTO.movimentType(), beverageWarehouseDTO.drinkType(), beverageWarehouseDTO.volume(),beverageWarehouseDTO.drinkName());
    }


}
