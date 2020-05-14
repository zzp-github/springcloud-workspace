# springcloud-workspace
2020-05-11
从无到有学习构建springcloud项目，配置各种技术框架。
------------------------------------------------
1. 配置swagger
配置swagger的时候，需要将其他模块（core）的代码加载到启动（web）模块中

2. swagger分组
配置文件，一个分组一个bean createStringApi，指定groupName

3. druid数据源
DruidConfiguration.java 文件可以不需要。不知道为啥。。
------------------------------------------------
2020-05-13
1. 项目启动时，控制台打印swagger地址。
------------------------------------------------
2020-05-14
1. 整合mybatis-plus
错误记录：
    1. Client does not support authentication protocol requested by server; conside...
    解决：
        use mysql;
        alter user ‘root’@‘localhost’ identified with mysql_native_password by ‘********’;
        flush privileges;
    
    2. Loading class `com.mysql.jdbc.Driver'. This is deprecated. The new driver cl...
    解决：
    driver-class-name: com.mysql.cj.jdbc.Driver
    3. Bean instantiation via factory method failed; nested exception is org.springframework.
