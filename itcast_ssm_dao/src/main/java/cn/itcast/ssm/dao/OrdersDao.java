package cn.itcast.ssm.dao;

import cn.itcast.ssm.domain.Member;
import cn.itcast.ssm.domain.Orders;
import cn.itcast.ssm.domain.Product;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * data layer
 * ordersDap
 */
@Repository
public interface OrdersDao {
    /**
     * search all orders
     * @return
     * @throws Exception
     */
    @Select("select * from orders")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property = "product",column = "productId",javaType = Product.class,one = @One(select = "cn.itcast.ssm.dao.ProductDao.findById"))
    })
    List<Orders> findAll() throws Exception;

    /**
     * find orders by id
     * @param ordersId
     * @return
     */
    @Select("select * from orders where id=#{ordersId}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property = "product",column = "productId",javaType = Product.class,one=@One(select = "cn.itcast.ssm.dao.ProductDao.findById")),
            @Result(property = "member",column = "memberId",javaType = Member.class,one=@One(select = "cn.itcast.ssm.dao.MemberDao.findById")),
            @Result(property = "travellers",column = "id",javaType = java.util.List.class,many = @Many(select = "cn.itcast.ssm.dao.TravellerDao.findByOrdersId"))

    })
    Orders findById(int ordersId) throws Exception;
}
