package ecommerce.spring.service.Impl;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ecommerce.spring.enties.Orders;
import ecommerce.spring.repository.AccountRepository;
import ecommerce.spring.repository.OrderRepository;
import ecommerce.spring.service.OrdersService;

@Service
public class OrderServiceImpl implements OrdersService<Orders> {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Collection<Orders> getAll() {
        return this.orderRepository.findAll();
    }

    // @Override
    // public Optional<Orders> findById(Long id) {
    // return this.orderRepository.findById(id);
    // }

    @Override
    public Orders saveOrder(String user_name, Orders orders) {
        return accountRepository.findById(user_name).map(account -> {
            orders.setAccount(account);
            return orderRepository.save(orders);
        }).orElseThrow(() -> new RuntimeException("orders not found"));
    }

    @Override
    public Orders editOrder(Long id, Orders orders) {
        return orderRepository.findById(id).map(currentOrder -> {
            currentOrder.setStatus(orders.getStatus());
            currentOrder.setTotalPrice(orders.getTotalPrice());
            currentOrder.setTitle(orders.getTitle());
            currentOrder.setPrice(orders.getPrice());
            currentOrder.setQuantity(orders.getQuantity());
            return orderRepository.save(orders);
        }).orElseThrow(() -> new RuntimeException("orders not found"));
    }

    @Override
    public void remove(Long id) {
        this.orderRepository.deleteById(id);
    }

}
