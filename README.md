# TravleManagement_System #
### spring+springmvc+mybatis+AdminLTE+PageHelper ###
### AdminLTE github: [AdminLTE](https://github.com/ColorlibHQ/AdminLTE) ###
### PageHelper github: [PageHelper](https://github.com/pagehelper/Mybatis-PageHelper) ###
# 1. System demo #

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
- **Spring security**
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
        |- src.main.java.cn.otcast.ssm.dao ----------------------------------------------------- 
            |- XXXDao --------------------------------------------------- Dao interface
    |- itcast_ssm_domain -------------------------------------------------------- entity (JavaBean)          
    |- itcast_ssm_service -------------------------------------------------------- application layer module
        |- src.main.java.cn.itcast.ssm.service -------------------------------------------------------- 
            |- XXXService --------------------------------------------------- Service interface
            |- impl --------------------------------------------------- 
                |    |- XXXServiceImpl -------------------------------------- Implementaion of Service interface
    |- itcast_ssm_web -------------------------------------------------------- presentation layer module
        |- src -------------------------------------------------------- 
            |- main --------------------------------------------------- 
                |- java ----------------------------------------------- 
                |   |-  cn -------------------------------------------- 
                |       |- itcast -------------------------------------- 
                |           |- ssm -------------------------------------- 
                |               |- controller -------------------------------------- 
                |                   |- XXXController -------------------------------------- Controller
                |- resources ------------------------------------------ resource
                    |- applicationContext ----------------------------------------------- spring config
                    |- springmvc ----------------------------------------------- springMVC config
                    |- db.properties ----------------------------------------------- database properties
                    |- log4j ----------------------------------------------- log properties
                |- web-app ------------------------------------------
                    |- WEB-INF ----------------------------------------------- 
                        |- web.xml
                    |- js ----------------------------------------------- static resources
                    |- css ----------------------------------------------- static resources
                    |- img ----------------------------------------------- static resources
                    |- plugins ----------------------------------------------- AdminLTE
                    |- pages ----------------------------------------------- web page
    |- itcast_ssm_utils -------------------------------------------------------- Util Class
    
# 4. Reference #
