package com.food.ordering.system.order.service.domain;

import com.food.ordering.system.domain.valueobject.OrderId;
import com.food.ordering.system.order.service.domain.entity.Order;
import com.food.ordering.system.order.service.domain.exception.OrderNotFoundException;
import com.food.ordering.system.order.service.domain.ports.output.repository.IOrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class OrderSagaHelper {

    private final IOrderRepository orderRepository;

    public OrderSagaHelper(IOrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order findOrder(String id) {
        Optional<Order> order = orderRepository.findById(new OrderId(UUID.fromString(id)));
        if (order.isEmpty()) {
            log.error("Order with id {} could not be found!", id);
            throw new OrderNotFoundException("Order with id " + id + " could not be found!");
        }

        return order.get();
    }

    public void saveOrder(Order order) {
        orderRepository.save(order);
    }
}
