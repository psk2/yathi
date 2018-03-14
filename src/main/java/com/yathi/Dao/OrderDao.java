package com.yathi.Dao;
import com.yathi.Entity.Order;
import com.yathi.Entity.Response;

import java.util.Collection;

public interface OrderDao {
    Collection<Order> getAllOrders();

    Order getOrderById(double id);

    Response getOrderById2(double id);

    Order getDispatchUpdate(double id);

    Collection<Order> deleteOrderById(int id);

    Order updateOrder(Order Order);

    Order insertOrder(Order Order);

    Order dispatchOrder(Order Order);


}
