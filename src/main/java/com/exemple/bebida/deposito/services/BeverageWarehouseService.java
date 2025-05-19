package com.exemple.bebida.deposito.services;

import com.exemple.bebida.deposito.models.dto.BeverageWarehouseDTO;
import com.exemple.bebida.deposito.models.entities.BeverageWarehouse;
import com.exemple.bebida.deposito.models.entities.BeverageWarehouseConfig;
import com.exemple.bebida.deposito.models.enuns.MovimentType;
import com.exemple.bebida.deposito.repositores.BeverageWarehouseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class BeverageWarehouseService {

    private final BeverageWarehouseRepository repository;
    private final BeverageWarehouseConfig config;


    public BeverageWarehouseService(BeverageWarehouseRepository repository, BeverageWarehouseConfig config) {
        this.repository = repository;
        this.config = config;
    }

    public BeverageWarehouse save(BeverageWarehouseDTO beverageWarehouseDTO) {
        return Stream.of(convertToModel(beverageWarehouseDTO))
                .map(beverageWarehouse -> {
                    verifyPermitSection(beverageWarehouse);
                    addOrRemoveVolumeInSection(beverageWarehouse);
                    totalVolumeOnSection(beverageWarehouse);
                    return repository.save(beverageWarehouse);
                })
                .findFirst()
                .orElseThrow();
    }

    public List<BeverageWarehouse> getAll() {
        return Optional.of(repository.findAll()).orElseThrow();
    }

    private void verifyPermitSection(BeverageWarehouse beverageWarehouse) {
        if (!config.getPERMIT_SECTION().contains(beverageWarehouse.getSection().toUpperCase())) {
            throw new RuntimeException("This section is not allowed !");
        }
    }

    private Double totalVolumeOnSection(BeverageWarehouse drinkDeposit) {
        return repository
                .findBySectionOrderByIdDesc(drinkDeposit.getSection())
                .stream()
                .findFirst()
                .map(BeverageWarehouse::getTotalVolumeInSection)
                .orElse(0.0);
    }

    public void addOrRemoveVolumeInSection(BeverageWarehouse beverageWarehouse) {
        double totalVolume = totalVolumeOnSection(beverageWarehouse);
        double volume = beverageWarehouse.getVolume();
        double actualVolume = totalVolume + (beverageWarehouse.getMovimentType().equals(MovimentType.ENTRY) ? volume : -volume);

        if (totalVolume <= 0 && beverageWarehouse.getMovimentType().equals(MovimentType.SELL)) {
            throw new RuntimeException("You can't make an output without having volume in stock !");
        }
        beverageWarehouse.totalVolumeInSection(actualVolume);
    }


    private BeverageWarehouse convertToModel(BeverageWarehouseDTO beverageWarehouseDTO) {
        return new BeverageWarehouse(beverageWarehouseDTO.id(), beverageWarehouseDTO.data(), beverageWarehouseDTO.responsible(), beverageWarehouseDTO.section(), beverageWarehouseDTO.movimentType(), beverageWarehouseDTO.drinkType(), beverageWarehouseDTO.drinkName(), beverageWarehouseDTO.volume());
    }


}
