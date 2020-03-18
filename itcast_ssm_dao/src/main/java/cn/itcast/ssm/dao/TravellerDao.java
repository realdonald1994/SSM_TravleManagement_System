package cn.itcast.ssm.dao;

import cn.itcast.ssm.domain.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * data layer
 * TravellerDao
 */
public interface TravellerDao {
    @Select("select * from traveller where id in (select travellerId from order_traveller where orderId=#{ordersId})")
    List<Traveller> findByOrdersId(int ordersId) throws Exception;
}
