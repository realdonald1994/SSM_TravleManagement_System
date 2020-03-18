package cn.itcast.ssm.domain;

import java.io.Serializable;

/**
 * traveller javabean
 */
public class Traveller implements Serializable {
    private Integer id;
    private String name;
    private String sex;
    private String phoneNum;
    private Integer credentialsType;//type of certificate: 0 driver license 1 passport 2 student id card
    private String credentialsTypeStr;
    private String credentialsNum;
    private Integer travellerType;//type of traveller: 0 adult 1 children
    private String travellerTypeStr;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Integer getCredentialsType() {
        return credentialsType;
    }

    public void setCredentialsType(Integer credentialsType) {
        this.credentialsType = credentialsType;
    }

    public String getCredentialsTypeStr() {
        if (credentialsType != null) {
            if (credentialsType == 0) {
                credentialsTypeStr = "driver license";
            } else if (credentialsType == 1) {
                credentialsTypeStr = "passport";
            } else if (credentialsType == 2) {
                credentialsTypeStr = "student id card";
            }
        }
        return credentialsTypeStr;
    }

    public void setCredentialsTypeStr(String credentialsTypeStr) {
        this.credentialsTypeStr = credentialsTypeStr;
    }

    public String getCredentialsNum() {
        return credentialsNum;
    }

    public void setCredentialsNum(String credentialsNum) {
        this.credentialsNum = credentialsNum;
    }

    public Integer getTravellerType() {
        return travellerType;
    }

    public void setTravellerType(Integer travellerType) {
        this.travellerType = travellerType;
    }

    public String getTravellerTypeStr() {
        if (travellerType != null) {
            if (travellerType == 0) {
                travellerTypeStr="adult";
            } else if (travellerType == 1){
                travellerTypeStr="children";
            }
        }
        return travellerTypeStr;
    }

    public void setTravellerTypeStr(String travellerTypeStr) {
        this.travellerTypeStr = travellerTypeStr;
    }
}
