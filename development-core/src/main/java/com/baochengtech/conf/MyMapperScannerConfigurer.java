package com.baochengtech.conf;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by liming on 17-3-2.
*/

@Configuration
@AutoConfigureAfter(MyBatisConfig.class)
public class MyMapperScannerConfigurer extends MapperScannerConfigurer {

    public MyMapperScannerConfigurer(){
        super.setBasePackage("com.baochengtech.mapper");
    }

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {

        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("com.baochengtech.mapper");
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionTemplate");
        return mapperScannerConfigurer;
    }
}


