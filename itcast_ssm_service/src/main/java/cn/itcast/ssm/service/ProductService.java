package cn.itcast.ssm.service;

import cn.itcast.ssm.domain.Product;
import java.util.List;

/**
 * application layer interface
 * product
 */
public interface ProductService {
    /**
     * search all product
     *
     * @return
     * @throws Exception
     */
    List<Product> findAll(Integer page,Integer size) throws Exception;

    /**
     * save product
     * @param product
     * @throws Exception
     */
    void save(Product product) throws Exception;

    /**
     * delete product
     * @param productId
     */
    void delete(Integer productId) throws Exception;

    /**
     * find product by id
     * @param productId
     * @return
     */
    Product findById(Integer productId) throws Exception;

    /**
     * update product
     * @param product
     */
    void update(Product product) throws Exception;

    /**
     * batch delete
     * @param ids
     */
    void batchDelete(List<Integer> ids) throws Exception;
}
