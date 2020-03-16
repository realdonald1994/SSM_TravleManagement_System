package cn.itcast.ssm.service;

import cn.itcast.ssm.domain.Product;
import java.util.List;

/**
 * application layer interface
 */
public interface ProductService {
    /**
     * search all product
     *
     * @return
     * @throws Exception
     */
    List<Product> findAll() throws Exception;
}
