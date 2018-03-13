package com.yathi.Dao;
import com.yathi.Entity.Order;

import java.util.Collection;

public interface OrderDao {
    Collection<Order> getAllOrders();

    Order getOrderById(double id);

    Collection<Order> deleteOrderById(int id);

    Order updateOrder(Order Order);

    Order insertOrder(Order Order);
}
