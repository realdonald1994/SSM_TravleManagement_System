package cn.itcast.ssm.service.impl;

import cn.itcast.ssm.dao.OrdersDao;
import cn.itcast.ssm.domain.Orders;
import cn.itcast.ssm.service.OrdersService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * application layer: implementation
 * orders service
 */
@Service
@Transactional
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    private OrdersDao ordersDao;

    /**
     * search all orders
     * @return
     * @throws Exception
     */
    @Override
    public List<Orders> findAll(Integer page,Integer size) throws Exception {
        //pageNum. pageSize
        PageHelper.startPage(page,size);
        return ordersDao.findAll();
    }

    /**
     * find order by id
     * @param ordersId
     * @return
     * @throws Exception
     */
    @Override
    public Orders findById(int ordersId) throws Exception {
        return ordersDao.findById(ordersId);
    }
}
