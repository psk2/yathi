package com.yathi.Dao;

import com.sun.org.apache.xpath.internal.operations.Or;
import com.yathi.Entity.Order;

import com.yathi.Entity.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ResourceNotFoundException;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.Null;
import javax.xml.crypto.Data;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.sql.Timestamp;


@Repository("mysql")
public class OrderDaoMySqlImpl implements OrderDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    //    @Autowired
//    private  Order order;
    private static class OrdersRowMapper implements RowMapper<Order> {

        @Override
        public Order mapRow(ResultSet resultSet, int i) throws SQLException {
            Order Order;
            Order = new Order();
            Order.setId(resultSet.getDouble("id"));
            Order.setBricks(resultSet.getInt("bricks"));
//                Order.setDispatch(resultSet.getBoolean("dispatch"));

            return Order;
        }

    }

    private static class OrdersRowMapper2 implements RowMapper<Order> {

        @Override
        public Order mapRow(ResultSet resultSet, int i) throws SQLException {
            Order Order;
            Order = new Order();
            Order.setId(resultSet.getDouble("id"));
            Order.setBricks(resultSet.getInt("bricks"));
            Order.setDispatch(resultSet.getBoolean("dispatch"));
            if (resultSet.next()) {
                System.out.println("Records found");
            } else {
                System.out.println("Records not found");
            }
            return Order;
        }

    }


    @Override
    public Collection<Order> getAllOrders() {
        final String sql = "Select id,bricks from Orders";

        List<Order> Orders = jdbcTemplate.query(sql, new OrdersRowMapper());
        return Orders;
    }


    @Override
    public Order getOrderById(double id) {
        final String sql = "Select * from Orders where id = ?";
        Order Orders = null;
        Orders = jdbcTemplate.queryForObject(sql, new OrdersRowMapper2(), id);
//        try {
//            Orders = jdbcTemplate.queryForObject(sql, new OrdersRowMapper2(), id);
//        } catch (DataAccessException e) {
//            return Orders;
//        }
        return Orders;
    }

    @Override
    public Collection<Order> deleteOrderById(int id) {
        final String sql = "Delete from Orders where id = ?";
        jdbcTemplate.update(sql, id);
        return this.getAllOrders();
    }

    @Override
    public Order updateOrder(Order Order) {
        final String sql = "update Orders set bricks= ? where id=?";
        final double id = Order.getId();
        final int bricks = Order.getBricks();
        jdbcTemplate.update(sql, new Object[]{bricks, id});
//        List<Order> Orders = jdbcTemplate.query(sql, new OrdersRowMapper()) ;
        return this.getOrderById(id);
    }

    @Override
    public Order insertOrder(Order Order) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        double settingId = timestamp.getTime();
        Order.setId(settingId);
        final String sql = " INSERT INTO Orders (id,bricks) VALUES (?,?)";
        final double id = Order.getId();
        final int bricks = Order.getBricks();
        jdbcTemplate.update(sql, new Object[]{id, bricks});
        return this.getOrderById(settingId);
    }

    @Override
    public Order getDispatchUpdate(double id) {
        final String sql = "Select * from Orders where id = ?";
        Order Orders = jdbcTemplate.queryForObject(sql, new OrdersRowMapper2(), id);
        return Orders;
    }

    @Override
    public Order dispatchOrder(Order Order) {
        Order.setDispatch(true);
        final String sql = "update Orders set dispatch= ? where id=?";
        final double id = Order.getId();
        final boolean dispatch = Order.isDispatch();
        System.out.println("dispatch value: " + dispatch);
        jdbcTemplate.update(sql, new Object[]{dispatch, id});
        return this.getDispatchUpdate(id);
    }

    //  Handling the error cases

    @Override
    public Response getOrderById2(double id) {
        final String sql = "Select * from Orders where id = ?";
        Order Orders = null;
        Response response = null;
        try {
            Orders = jdbcTemplate.queryForObject(sql, new OrdersRowMapper2(), id);
        } catch (DataAccessException e) {
            System.out.println("in the catch block");
            if (Orders == null) {
                System.out.println("No resultls Found");
            }
            response.setStatusCode(400);
            response.setStatusMessage("Records Not Found");
            System.out.println("Response: "+ response);
            return response;
        } catch (NullPointerException n) {
            System.out.println("in the catch block2");
            if (Orders == null) {
                System.out.println("No resultls Found2");
            }
            response.setStatusCode(400);
            response.setStatusMessage("Records Not Found2");

            return response;
        }
        return response;
    }
}
