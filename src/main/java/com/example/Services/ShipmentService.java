package com.example.Services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Item;
import com.example.model.Shipment;
import com.example.repository.ShipmentRepository;

@Service
public class ShipmentService {
    @Autowired
    private ShipmentRepository shipmentRepository;
    @Autowired
    private ItemService itemService;

    public Shipment addShipment(Shipment shipment) {
        Item item = itemService.getItemById(shipment.getItemId()).orElseThrow(() -> new RuntimeException("Item not found"));
        item.setQuantity(item.getQuantity() + shipment.getQuantity()); // Update stock level
        itemService.updateItem(item);
        shipment.setArrivalDate(LocalDateTime.now());
        return shipmentRepository.save(shipment);
    }

    public List<Shipment> getAllShipments() {
        return shipmentRepository.findAll();
    }

    public Optional<Shipment> getShipmentById(Long id) {
        return shipmentRepository.findById(id);
    }
}
