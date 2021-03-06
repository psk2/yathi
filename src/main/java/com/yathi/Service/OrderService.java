package com.yathi.Service;

import com.yathi.Dao.OrderDao;
import com.yathi.Entity.Order;
import com.yathi.Entity.Response;
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

    //  Create an order
    public Order insertOrder(Order order) {

        this.orderDao.insertOrder(order);
        return this.orderDao.getOrderById(order.getId());
    }

    //  Update an order
    public Order updateOrder(Order order) {

        this.orderDao.updateOrder(order);

        return this.orderDao.getOrderById(order.getId());
    }

    //    Get all Orders
    public Collection<Order> getAllOrders() {

        return this.orderDao.getAllOrders();
    }

    //    Get Order By Id
    public Order getOrderById(double id) {
        return this.orderDao.getOrderById(id);
    }

    //Dispatch Order
    public Order dispatchOrder(Order order) {
        this.orderDao.dispatchOrder(order);

        return this.orderDao.getDispatchUpdate(order.getId());
    }

    public Response getOrderById2(double id) {
        return this.orderDao.getOrderById2(id);
    }

}
