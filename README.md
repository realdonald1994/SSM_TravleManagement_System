# TravelManagement_System #

![Version](https://img.shields.io/badge/release-v1.0.8-blue)
[![GITEE](https://img.shields.io/badge/Gitee-repo-green)](https://gitee.com/realdonald1994/SSM_TravleManagement_System/tree/master)


### spring+springmvc+mybatis+AdminLTE+PageHelper ###
### AdminLTE github: [AdminLTE](https://github.com/ColorlibHQ/AdminLTE) ###
### PageHelper github: [PageHelper](https://github.com/pagehelper/Mybatis-PageHelper) ###
### Spring Security: [Spring Security](https://spring.io/projects/spring-security) ###
# 1. System demo #
### 1.1 User Management ###
![](https://github.com/realdonald1994/SSM_TravelManagement_System/blob/master/User.png)
### 1.2 Product Management ###
![](https://github.com/realdonald1994/SSM_TravelManagement_System/blob/master/Product.png)
# 2. Technical framework #
### 2.1. Development environment ###
- **JDK1.8**
- **Apache-Maven-3.5.2**  
- **InteliJ IDEA**
- **Apache-Tomcat-8.5.47**

### 2.2. BackEnd ###
- **Spring**
- **Spring MVC**
- **MyBatis**
### 2.3. Authority Framework ###
- **Spring Security**
- **JSR250**
### 2.4. Database and connection pool ###
- **MySQL**
- **JdbcTemplate**
### 2.5. Pagination tool ###
- **PagHelper**
### 2.6. FrontEnd ###
- **AdminLTE**

# 3. Project structure #


    itcast_ssm --------------------------------------------------------- parent module
    |- itcast_ssm_dao -------------------------------------------------------- data layer module
        |- src.main.java.cn.otcast.ssm.dao ---------------------------------------- package 
            |- XXXDao --------------------------------------------------- Dao interface
    |- itcast_ssm_domain -------------------------------------------------------- entity (JavaBean)          
    |- itcast_ssm_service -------------------------------------------------------- application layer module
        |- src.main.java.cn.itcast.ssm.service ------------------------------------------- package 
            |- XXXService --------------------------------------------------- Service interface
            |- impl --------------------------------------------------- Service Implementation package
                |    |- XXXServiceImpl -------------------------------------- Implementaion of Service interface
    |- itcast_ssm_web -------------------------------------------------------- presentation layer module
        |- src -------------------------------------------------------- src
            |- main --------------------------------------------------- main
                |- java ----------------------------------------------- source root
                |   |-  cn -------------------------------------------- package
                |       |- itcast -------------------------------------- package
                |           |- ssm -------------------------------------- package
                |               |- controller -------------------------------------- controller package 
                |                   |- XXXController -------------------------------------- Controller
                |- resources ------------------------------------------ resource
                    |- applicationContext ----------------------------------------------- spring config
                    |- springmvc ----------------------------------------------- springMVC config
                    |- db.properties ----------------------------------------------- database properties
                    |- log4j ----------------------------------------------- log properties
                |- web-app ------------------------------------------ Directory
                    |- WEB-INF ----------------------------------------------- Directory
                        |- web.xml ------------------------------------------- web config file
                    |- js ----------------------------------------------- static resources
                    |- css ----------------------------------------------- static resources
                    |- img ----------------------------------------------- static resources
                    |- plugins ----------------------------------------------- AdminLTE
                    |- pages ----------------------------------------------- web page
    |- itcast_ssm_utils -------------------------------------------------------- Util Class
    
# 4. Reference #
