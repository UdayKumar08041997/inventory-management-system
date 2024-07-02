package com.example.Services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Item;
import com.example.model.Order;
import com.example.repository.OrderRepository;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ItemService itemService;

    public Order createOrder(Order order, List<Long> itemIds) {
        for (Long itemId : itemIds) {
            Item item = itemService.getItemById(itemId).orElseThrow(() -> new RuntimeException("Item not found"));
            item.setQuantity(item.getQuantity() - 1); // Adjust stock level
            itemService.updateItem(item);
        }
        order.setOrderDate(LocalDateTime.now());
        order.setStatus("Created");
        return orderRepository.save(order);
    }

    public Order updateOrder(Order order) {
        return orderRepository.save(order);
    }

    public void cancelOrder(Long id) {
        orderRepository.deleteById(id);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Optional<Order> getOrderById(Long id) {
        return orderRepository.findById(id);
    }
}
