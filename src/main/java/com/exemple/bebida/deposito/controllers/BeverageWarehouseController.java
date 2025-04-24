package com.exemple.bebida.deposito.controllers;


import com.exemple.bebida.deposito.models.dto.BeverageWarehouseDTO;
import com.exemple.bebida.deposito.models.entities.BeverageWarehouse;
import com.exemple.bebida.deposito.services.BeverageWarehouseService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BeverageWarehouseController {

    private final BeverageWarehouseService beverageWarehouse;

    public BeverageWarehouseController(BeverageWarehouseService beverageWarehouse) {
        this.beverageWarehouse = beverageWarehouse;
    }

    @PostMapping("/save")
    public ResponseEntity<BeverageWarehouse> save(@RequestBody @Valid BeverageWarehouseDTO beverageWarehouseDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(beverageWarehouse.save(beverageWarehouseDTO));
    }

    @GetMapping
    public ResponseEntity<List<BeverageWarehouse>>getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(beverageWarehouse.getAll());
    }


}
