//package com.mygg.mygg.config;
//
//import javax.sql.DataSource;
//
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class MybatisConfig {
//    @Autowired
//    private ApplicationContext applicationContext;
//    @Autowired
//    private DataSource dataSource;
//
//    @Bean
//    public org.apache.ibatis.session.Configuration ibatisConfiguration() {
//        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
//        configuration.setMapUnderscoreToCamelCase(true);
//        return configuration;
//    }
//
//    @Bean
//    public SqlSessionFactory sqlSessionFactory() throws Exception {
//        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
//        sessionFactoryBean.setDataSource(dataSource);
//        sessionFactoryBean.setConfiguration(ibatisConfiguration());
//        sessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:/mappers/*.xml"));
//        return sessionFactoryBean.getObject();
//    }
//}