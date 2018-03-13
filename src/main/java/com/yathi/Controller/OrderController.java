package com.yathi.Controller;

import com.yathi.Entity.Order;
import com.yathi.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;



    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Order insertOrder(@RequestBody Order order){

        return this.orderService.insertOrder(order);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Order updateOrder(@RequestBody Order order){
        return this.orderService.updateOrder(order);
    }

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Order> getAllOrders(){

        return this.orderService.getAllOrders();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Order getStudentById(@PathVariable("id") double id){
        return this.orderService.getOrderById(id);
    }

}
