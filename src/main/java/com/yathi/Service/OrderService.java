package com.yathi.Service;

import com.yathi.Dao.OrderDao;
import com.yathi.Entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.security.sasl.SaslServer;
import java.util.Collection;

@Service
public class OrderService {
    @Autowired
    @Qualifier("mysql")
    public OrderDao orderDao;


    public Order insertOrder(Order order) {

        this.orderDao.insertOrder(order);
        return this.orderDao.getOrderById(order.getId());
    }

    public Order updateOrder(Order order) {

        this.orderDao.updateOrder(order);

        return this.orderDao.getOrderById(order.getId());
    }

    public Collection<Order> getAllOrders() {

        return this.orderDao.getAllOrders();
    }

    public Order getOrderById(double id) {
        return this.orderDao.getOrderById(id);
    }

}
