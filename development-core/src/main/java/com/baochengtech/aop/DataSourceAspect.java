package com.baochengtech.aop;

import com.baochengtech.annotation.DataSourceAnnotation;
import com.baochengtech.datasource.DataSourceTypeManager;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * Created by liming on 17-3-1.
 */

@Component
@Aspect
public class DataSourceAspect {

    @Pointcut("execution(* com.baochengtech.service.*.*(..))")
    public void pointCut(){}

    @Before(value = "pointCut()")
    public void before(JoinPoint point)
    {
        Object target = point.getTarget();
        System.out.println(target.toString());
        String method = point.getSignature().getName();
        System.out.println(method);
        Class<?>[] clazz = target.getClass().getInterfaces();
        Class<?>[] parameterTypes = ((MethodSignature) point.getSignature())
                .getMethod().getParameterTypes();
        try {
            Method m = clazz[0].getMethod(method, parameterTypes);
            System.out.println(m.getName());
            if (m != null && m.isAnnotationPresent(DataSourceAnnotation.class)) {
                DataSourceAnnotation data = m.getAnnotation(DataSourceAnnotation.class);
                DataSourceTypeManager.set(data.ds());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
