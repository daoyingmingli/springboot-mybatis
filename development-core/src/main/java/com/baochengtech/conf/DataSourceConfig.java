package com.baochengtech.conf;

import com.baochengtech.datasource.DataSourcesEnum;
import com.baochengtech.datasource.DynamicDataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by liming on 17-3-1.
 */

@Configuration
public class DataSourceConfig {
    private Class<? extends DataSource> datasourceType = com.alibaba.druid.pool.DruidDataSource.class;

    @Bean(name = "master")
    @ConfigurationProperties(prefix = "spring.datasource.master")
    public DataSource dataSourceMaster() {
        return DataSourceBuilder.create().type(datasourceType).build();
    }

    @Bean(name = "slave")
    @ConfigurationProperties(prefix = "spring.datasource.slave")
    public DataSource dataSourceSlave() {
        return DataSourceBuilder.create().type(datasourceType).build();
    }


    @Bean
    @Primary
    @DependsOn({"master", "slave"})
    public DynamicDataSource dynamicDataSource() {
        DynamicDataSource proxy = new DynamicDataSource();

        //表示可用的数据源,包括写和读数据源
        Map<Object, Object> targetDataSources = new HashMap<>();

        targetDataSources.put(DataSourcesEnum.MASTER, dataSourceMaster());

        //如果有多个DataSource,需要设置多个
        targetDataSources.put(DataSourcesEnum.SLAVE, dataSourceSlave());

        //设置默认的数据源为写数据源
        proxy.setDefaultTargetDataSource(dataSourceMaster());

        proxy.setTargetDataSources(targetDataSources);

        return proxy;
    }


}
