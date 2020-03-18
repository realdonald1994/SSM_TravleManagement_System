package cn.itcast.ssm.dao;

import cn.itcast.ssm.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * data layer
 * productDao
 */
@Repository
public interface ProductDao {

    /***
     * search all product
     * @return
     */
    @Select("select * from product")
    List<Product> findAll() throws Exception;

    /**
     * find one product
     * @return
     * @throws Exception
     */
    @Select("select * from product where id=#{id}")
    Product findById(Integer id) throws Exception;

    /**
     * save product
     * @param product
     */
    @Insert("insert into product (productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) values(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void save(Product product);
}
