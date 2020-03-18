# TravleManagement_System #
## spring+springmvc+mybatis+AdminLTE
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
### 6. FrontEnd ###
- **AdminLTE**

# 3. Project structure #


    itcast_ssm --------------------------------------------------------- parent module
    |- itcast_ssm_dao -------------------------------------------------------- data layer module
        |- src -------------------------------------------------------- package
            |- main --------------------------------------------------- package
                |- java ----------------------------------------------- package
                |   |-  cn -------------------------------------------- package
                |       |- itcast -------------------------------------- package
                |           |- ssm -------------------------------------- package
                |               |- dao -------------------------------------- package
                |                   |- XXXDao -------------------------------------- Dao interface
    |- itcast_ssm_domain -------------------------------------------------------- entity (JavaBean)          
    |- itcast_ssm_service -------------------------------------------------------- application layer module
        |- src -------------------------------------------------------- package
            |- main --------------------------------------------------- package
                |- java ----------------------------------------------- package
                |   |-  cn -------------------------------------------- package
                |       |- itcast -------------------------------------- package
                |           |- ssm -------------------------------------- package
                |               |- service -------------------------------------- package
                |                   |- XXXService -------------------------------------- Service interface
                |                   |- impl -------------------------------------- package
                |                       |- XXXServiceImpl -------------------------------------- Implementaion of Service interface
    |- itcast_ssm_web -------------------------------------------------------- presentation layer module
        |- src -------------------------------------------------------- package
            |- main --------------------------------------------------- package
                |- java ----------------------------------------------- package
                |   |-  cn -------------------------------------------- package
                |       |- itcast -------------------------------------- package
                |           |- ssm -------------------------------------- package
                |               |- controller -------------------------------------- package
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
