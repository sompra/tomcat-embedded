package com.sompra.configuration;

import com.sompra.configuration.tomcat.AppConfig;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import javax.servlet.ServletException;
import java.io.File;
import java.util.Properties;

/**
 * Created by somprasong
 * Date: 10/11/2018
 * Time: 09:53
 */

@Configuration
@ImportResource("classpath:tomcat-config.xml")
public class TomcatConfigurer {

    private static Logger LOG = LoggerFactory.getLogger(TomcatConfigurer.class);

    @Autowired
    private Properties tomcatProperties;


    @Value("${tomcat.port}")
    private Integer port = 8080;

    @Value("${tomcat.basedir}")
    private String baseDir;

    @Value("${tomcat.webapp.path}")
    private String webAppPath;

    @Value("${tomcat.servlet.path}")
    private String servletPath;


    public void start() {

        Tomcat tomcat = new Tomcat();

        /* init tomcat properties */
        System.getProperties().putAll(tomcatProperties);

        try {
            String baseDir = getBaseDir();
            String webAppPath = getWebAppPath();

            LOG.info("Start tomcat embedded");
            LOG.info("Tomcat [port] = {}", port);
            LOG.info("Tomcat [base path] : {}", baseDir);
            LOG.info("Tomcat [webapp path] : {}", webAppPath);
            LOG.info("Tomcat [servlet context] {}", servletPath);

            tomcat.setBaseDir(new File(baseDir).getAbsolutePath());
            tomcat.setPort(port);
            tomcat.addWebapp(servletPath, webAppPath);

            tomcat.getHost().setAppBase(".");
            tomcat.getServer().setCatalinaBase(null);

            tomcat.start();
        } catch (ServletException | LifecycleException exception) {
            //
        }

        tomcat.getServer().await();
        /* webapp directory in dev mode */
    }

    private String getBaseDir() {
        String property = System.getProperties().getProperty("app.home");

        if (null != property) {
            return property;
        }

        return baseDir;
    }

    private String getWebAppPath() {
        String property = System.getProperties().getProperty("app.home");

        if (null != property) {
            return property + File.separator + "webapp";
        }

        return webAppPath;
    }

    public Properties getTomcatProperties() {
        return tomcatProperties;
    }

    public void setTomcatProperties(Properties tomcatProperties) {
        this.tomcatProperties = tomcatProperties;
    }

}
