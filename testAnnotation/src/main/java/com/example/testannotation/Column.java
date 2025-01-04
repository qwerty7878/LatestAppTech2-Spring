package com.example.testannotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)  //  필드에 적용
@Retention(RetentionPolicy.RUNTIME)
public @interface Column {
    boolean nullable() default true;    //  null 허용 여부
}
