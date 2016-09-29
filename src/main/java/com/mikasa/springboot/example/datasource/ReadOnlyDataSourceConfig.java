package com.mikasa.springboot.example.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * 只读数据源
 * Created by sherlock on 16/9/12.
 */


@Configuration
@MapperScan(basePackages = ReadOnlyDataSourceConfig.PACKAGE, sqlSessionFactoryRef = "readOnlySqlSessionFactory")
public class ReadOnlyDataSourceConfig {
    static final String PACKAGE = "com.mikasa.springboot.example.mapper.readonly";

    @Value("${druid.readonly.mysql.url}")
    private String dbUrl;
    @Value("${druid.readonly.mysql.username}")
    private String dbUser;
    @Value("${druid.readonly.mysql.password}")
    private String dbPassword;

    @Bean(name = "readOnlyDataSource")
    public DataSource readOnlyDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl(dbUrl);
        dataSource.setUsername(dbUser);
        dataSource.setPassword(dbPassword);
        return dataSource;
    }

    @Bean(name = "readOnlyTransactionManager")
    public DataSourceTransactionManager readOnlyTransactionManager(@Qualifier("readOnlyDataSource") DataSource readOnlyDataSource) {
        return new DataSourceTransactionManager(readOnlyDataSource);
    }

    @Bean(name = "readOnlySqlSessionFactory")
    public SqlSessionFactory readOnlySqlSessionFactory(@Qualifier("readOnlyDataSource") DataSource readOnlyDataSource) throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(readOnlyDataSource);
        sessionFactory.setFailFast(true);
        sessionFactory.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sessionFactory.setMapperLocations(resolver.getResources("classpath:/mybatis/*.xml"));
        return sessionFactory.getObject();
    }
}
