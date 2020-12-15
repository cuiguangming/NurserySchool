package com.nursery.common.annotations;


import org.springframework.core.annotation.Order;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Order(1)
public @interface OperationAnnotation {

    /**
     * 操作内容
     * @return
     */
    String context();
}
