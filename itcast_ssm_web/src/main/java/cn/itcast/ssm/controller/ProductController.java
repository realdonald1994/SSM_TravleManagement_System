package cn.itcast.ssm.controller;

import cn.itcast.ssm.domain.Product;
import cn.itcast.ssm.service.ProductService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.ArrayList;
import java.util.List;

/**
 * presentation layer:product_controller
 */
@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    /**
     * search all product
     * @return
     * @throws Exception
     */
    @RequestMapping("/findAll.do")
//    @RolesAllowed("ADMIN")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1")Integer page,
                                @RequestParam(name = "size",required = true,defaultValue = "5")Integer size) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Product> products = productService.findAll(page,size);
        PageInfo pageInfo = new PageInfo(products);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("product-list");
        return mv;
    }

    /**
     * save product
     * @param product
     */
    @RequestMapping("/save.do")
    public String save(Product product) throws Exception {
        productService.save(product);
        return "redirect:findAll.do";
    }


    /**
     * delete product
     * @param productId
     * @return
     * @throws Exception
     */
    @RequestMapping("/delete.do")
    public String delete(@RequestParam(name = "id",required = true) Integer productId) throws Exception{
        productService.delete(productId);
        return "redirect:findAll.do";
    }

    /**
     * find product by id
     * @param productId
     * @return
     * @throws Exception
     */
    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "id",required = true) Integer productId) throws Exception{
        ModelAndView mv = new ModelAndView();
        Product product = productService.findById(productId);
        mv.addObject("product",product);
        mv.setViewName("product-update");
        return mv;
    }

    @RequestMapping("/update.do")
    public String update(Product product)  throws  Exception{
        productService.update(product);
        return "redirect:findAll.do";
    }

    @RequestMapping("/batchDelete.do")
    public String batchDelete(String itemList) throws Exception{
        String[] items = itemList.split(",");
        List<Integer> ids = new ArrayList<>();
        for(String item:items){
            ids.add(Integer.parseInt(item));
        }
        productService.batchDelete(ids);
        return "redirect:findAll.do";
    }
}
