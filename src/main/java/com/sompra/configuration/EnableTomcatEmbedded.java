package com.sompra.configuration;

import org.apache.catalina.startup.Tomcat;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * Created by somprasong
 * Date: 10/11/2018
 * Time: 09:57
 */

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
@Import(TomcatConfigurer.class)
public @interface EnableTomcatEmbedded {
}
