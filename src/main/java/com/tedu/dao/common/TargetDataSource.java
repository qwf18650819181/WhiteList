package com.tedu.dao.common;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TargetDataSource {

    String name() default TargetDataSource.DB1;

    public static String DB1 = "dataSource1";

    public static String DB2 = "dataSource2";
}
