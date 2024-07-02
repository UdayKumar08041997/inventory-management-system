package com.example.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Item;
import com.example.model.Order;
import com.example.model.Supplier;
import com.example.repository.ItemRepository;
import com.example.repository.OrderRepository;
import com.example.repository.SupplierRepository;

@Service
public class ReportingService {
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private SupplierRepository supplierRepository;

    public List<Item> getStockLevels() {
        return itemRepository.findAll();
    }

    public List<Order> getOrderStatuses() {
        return orderRepository.findAll();
    }

    public List<Supplier> getSupplierPerformance() {
        return supplierRepository.findAll();
    }
}
