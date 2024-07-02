package com.example.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Services.ReportingService;
import com.example.model.Item;
import com.example.model.Order;
import com.example.model.Supplier;

@RestController
@RequestMapping("/api/reports")
public class ReportingController {
    @Autowired
    private ReportingService reportingService;

    @GetMapping("/stock-levels")
    public ResponseEntity<List<Item>> getStockLevels() {
        return new ResponseEntity<>(reportingService.getStockLevels(), HttpStatus.OK);
    }

    @GetMapping("/order-statuses")
    public ResponseEntity<List<Order>> getOrderStatuses() {
        return new ResponseEntity<>(reportingService.getOrderStatuses(), HttpStatus.OK);
    }

    @GetMapping("/supplier-performance")
    public ResponseEntity<List<Supplier>> getSupplierPerformance() {
        return new ResponseEntity<>(reportingService.getSupplierPerformance(), HttpStatus.OK);
    }
}
