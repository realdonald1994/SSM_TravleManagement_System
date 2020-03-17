package cn.itcast.ssm.domain;

import cn.itcast.utils.DateUtil;

import java.io.Serializable;
import java.util.Date;

/**
 * product javabean
 */
public class Product implements Serializable {
    private Integer id; // primary key
    private String productNum; // pro_num
    private String productName;// pro_name;
    private String cityName;// dep city name
    private Date departureTime;//dep_time
    private String departureTimeStr;
    private Double productPrice;//pro_price;
    private String productDesc;// pro_desc;
    private Integer productStatus; //status:0 close, 1:open
    private String productStatusStr;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductNum() {
        return productNum;
    }

    public void setProductNum(String productNum) {
        this.productNum = productNum;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public String getDepartureTimeStr() {
        if(departureTime!=null){
           return DateUtil.dateToString(departureTime,"yyyy-MM-dd HH:mm:ss");
        }
        return departureTimeStr;

    }

    public void setDepartureTimeStr(String departureTimeStr) {
        this.departureTimeStr = departureTimeStr;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public Integer getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(Integer productStatus) {
        this.productStatus = productStatus;
    }

    public String getProductStatusStr() {
        if(productStatus !=null){
            if(productStatus==0){
                productStatusStr="close";
            }
            if(productStatus==1){
                productStatusStr="open";
            }
        }
        return productStatusStr;
    }

    public void setProductStatusStr(String productStatusStr) {
        this.productStatusStr = productStatusStr;
    }
}
