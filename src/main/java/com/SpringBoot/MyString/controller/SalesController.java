package com.SpringBoot.MyString.controller;


import com.SpringBoot.MyString.entity.Sales;
import com.SpringBoot.MyString.service.SalesService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/mage")
@RestController
@AllArgsConstructor
public class SalesController {
    private SalesService salesService;

    @PostMapping
    public ResponseEntity<Sales> createSales(@RequestBody Sales sales){
        Sales mysales1=salesService.createSales(sales);
        return new ResponseEntity<>(mysales1, HttpStatus.CREATED);
    }
    //buid get sale by id rest api
    @GetMapping
    public ResponseEntity<Sales> getSalesById(@PathVariable("id") Long salesId){
        Sales mysales2=salesService.getSalesById(salesId);
        return new ResponseEntity<>(mysales2,HttpStatus.OK);
    }
    //build get all sales
    @GetMapping
    public ResponseEntity<List<Sales>> getAllSales(){
        List<Sales> mysales3=salesService.getAllSales();
        return new ResponseEntity<>(mysales3, HttpStatus.OK);
    }
    //build update sales rest api
    @PutMapping
    public ResponseEntity<Sales> updateSales(@RequestBody Sales sales, @PathVariable("id") Long salesId){
        sales.setId(salesId);
        Sales updatedSales=salesService.updateSales(sales);
        return new ResponseEntity<>(updatedSales,HttpStatus.OK);
    }
    @DeleteMapping
    public ResponseEntity<String> deleteSales(@PathVariable("id") Long salesId){
        salesService.deleteSales(salesId);
        return new ResponseEntity<>("Sales deleted", HttpStatus.OK);
    }
}
