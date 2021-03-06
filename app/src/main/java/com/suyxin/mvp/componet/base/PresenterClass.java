package com.suyxin.mvp.componet.base;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Created by suyxin on 2018/3/7 12:16.
 */
@Inherited  //@Inherited注解来实现注解继承。
@Retention(RetentionPolicy.RUNTIME)//运行时保留
@Target(ElementType.TYPE)
public @interface PresenterClass {
    Class< ? extends BasePresenter> value();
}
