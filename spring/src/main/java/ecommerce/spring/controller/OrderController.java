package ecommerce.spring.controller;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ecommerce.spring.enties.Orders;
import ecommerce.spring.repository.OrderRepository;
import ecommerce.spring.service.Impl.OrderServiceImpl;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class OrderController {

    @Autowired
    private OrderServiceImpl orderServiceImpl;

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/order")
    public Page<Orders> getAll(Pageable pageable) {
        return this.orderRepository.findAll(pageable);
    }

    @GetMapping("/order/search")
    public Collection<Orders> searchOrders(@RequestParam String keyword) {
        return this.orderRepository.searchOrders(keyword);
    }

    // @GetMapping("/account/{user_name}/order")
    // public Page<Orders> getOrderToAccount(@PathVariable(value = "user_name")
    // String user_name, Pageable pageable) {
    // return orderRepository.findOrderByAccount(user_name, pageable);
    // }

    @GetMapping("/account/{user_name}/order")
    public Page<Orders> getProductToCategory(@RequestParam String user_name, Pageable pageable) {
        return this.orderRepository.findOrderByAccount(user_name, pageable);
    }

    @PostMapping("/account/{user_name}/order")
    public Orders createOrderToAccount(@PathVariable(value = "user_name") String user_name,
            @Valid @RequestBody Orders order) {
        return this.orderServiceImpl.saveOrder(user_name, order);
    }

    @PutMapping("/account/{user_name}/order/{product_id}")
    public Orders updateOrderToAccount(@PathVariable Long product_id, @PathVariable String user_name,
            @RequestBody Orders order) {
        return this.orderServiceImpl.editOrder(product_id, order);
    }

    @DeleteMapping("/order/{id}")
    public void deleteAccount(@PathVariable Long id) {
        this.orderServiceImpl.remove(id);
    }
}
