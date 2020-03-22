package cn.itcast.ssm.service;

import cn.itcast.ssm.domain.Orders;

import java.util.List;
/**
 * application layer interface
 * orders
 */
public interface OrdersService {
    List<Orders> findAll(Integer page,Integer size)throws Exception;

    Orders findById(int ordersId) throws Exception;
}
