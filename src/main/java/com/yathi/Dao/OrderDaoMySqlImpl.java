package com.yathi.Dao;

import com.sun.org.apache.xpath.internal.operations.Or;
import com.yathi.Entity.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ResourceNotFoundException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.sql.Timestamp;

@Repository("mysql")
public class OrderDaoMySqlImpl implements OrderDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static class OrdersRowMapper implements RowMapper<Order> {

        @Override
        public Order mapRow(ResultSet resultSet, int i) throws SQLException {
            try {
                Order Order = new Order();
                Order.setId(resultSet.getDouble("id"));
                Order.setBricks(resultSet.getInt("bricks"));
//            Order.setDispatch(resultSet.getString("name"));

                return Order;

            } catch (EmptyResultDataAccessException e) {
                return null;

            }
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
        String s = "hai";
        Order Orders = jdbcTemplate.queryForObject(sql, new OrdersRowMapper(), id);
        if (Orders == null) {
            System.out.println("No resultls Found");
        }
        System.out.println("selected order: " + Orders);
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
}
