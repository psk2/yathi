package com.yathi.Controller;

import com.yathi.Entity.Order;
import com.yathi.Entity.Response;
import com.yathi.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Collection;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;


    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Order insertOrder(@RequestBody Order order) {

        return this.orderService.insertOrder(order);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Order updateOrder(@RequestBody Order order) {
        return this.orderService.updateOrder(order);
    }

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Order> getAllOrders() {

        return this.orderService.getAllOrders();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Response getOrderById(@PathVariable("id") double id) {
        return this.orderService.getOrderById2(id);
    }

    @RequestMapping(value = "/dispatch", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Order getDispatch(@RequestBody Order order) {
        return this.orderService.dispatchOrder(order);
    }

}
