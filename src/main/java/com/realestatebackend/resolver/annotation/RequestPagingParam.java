package com.realestatebackend.resolver.annotation;

import java.lang.annotation.*;

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RequestPagingParam {

    boolean required() default true;
}

