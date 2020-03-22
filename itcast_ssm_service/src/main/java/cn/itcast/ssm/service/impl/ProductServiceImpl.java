package cn.itcast.ssm.service.impl;

import cn.itcast.ssm.dao.ProductDao;
import cn.itcast.ssm.domain.Product;
import cn.itcast.ssm.service.ProductService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * application layer: implementation
 * product service
 */
@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;

    /**
     * search all product
     * @return
     * @throws Exception
     */
    @Override
    public List<Product> findAll(Integer page,Integer size) throws Exception {
        PageHelper.startPage(page,size);
        return productDao.findAll();
    }

    /**
     * save product
     * @param product
     * @throws Exception
     */
    @Override
    public void save(Product product) throws Exception {
        productDao.save(product);
    }

    /**
     * delete product
     * @param productId
     * @throws Exception
     */
    @Override
    public void delete(Integer productId) throws Exception {
        productDao.delete(productId);
    }

    /**
     * search product by id
     * @param productId
     * @return
     * @throws Exception
     */
    @Override
    public Product findById(Integer productId) throws Exception {
        return productDao.findById(productId);
    }

    /**
     * update product
     * @param product
     * @throws Exception
     */
    @Override
    public void update(Product product) throws Exception {
        productDao.update(product);
    }

    /**
     * batch delete
     * @param ids
     * @throws Exception
     */
    @Override
    public void batchDelete(List<Integer> ids) throws Exception {
        for(Integer id:ids) {
            productDao.delete(id);
        }
    }
}
