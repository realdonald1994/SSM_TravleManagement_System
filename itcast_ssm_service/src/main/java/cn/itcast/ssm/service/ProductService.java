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
    List<Product> findAll(int page,int size) throws Exception;

    /**
     * save product
     * @param product
     * @throws Exception
     */
    void save(Product product) throws Exception;
}
