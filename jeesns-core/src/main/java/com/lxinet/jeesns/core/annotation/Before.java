package com.lxinet.jeesns.core.annotation;

import com.lxinet.jeesns.interceptor.JeesnsInterceptor;

import java.lang.annotation.*;

/**
 * Created by zchuanzhao on 2016/11/26.
 */
@Inherited
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD})
public @interface Before {
    Class<? extends JeesnsInterceptor> value();
}
