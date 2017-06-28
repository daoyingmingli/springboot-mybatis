package com.baochengtech.annotation;

import com.baochengtech.datasource.DataSourcesEnum;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface DataSourceAnnotation {
    DataSourcesEnum ds() default DataSourcesEnum.MASTER;
}
