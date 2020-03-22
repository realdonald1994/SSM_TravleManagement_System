package cn.itcast.ssm.dao;

import cn.itcast.ssm.domain.Product;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
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

    /**
     * delete product
     * @param productId
     * @throws Exception
     */
    @Delete("delete from product where id=#{productId}")
    void delete(Integer productId) throws Exception;

    /**
     * update product
     * @param product
     * @throws Exception
     */
    @Update("update product set productNum=#{productNum},productName=#{productName},cityName=#{cityName},departureTime=#{departureTime},productPrice=#{productPrice},productDesc=#{productDesc},productStatus=#{productStatus} where id=#{id}")
    void update(Product product) throws Exception;


}
