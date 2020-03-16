package cn.itcast.ssm.dao;

import cn.itcast.ssm.domain.Product;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * data layer
 */
public interface ProductDao {

    /***
     * search all product
     * @return
     */
    @Select("select * from product")
    List<Product> findAll() throws Exception;
}
