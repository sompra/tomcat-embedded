package com.sompra.main;

import com.sompra.configuration.EnableTomcatEmbedded;
import com.sompra.configuration.TomcatConfigurer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by somprasong
 * Date: 10/11/2018
 * Time: 09:49
 */


@EnableTomcatEmbedded
public class ApplicationLauncher {

  public static void main(String[] args) throws Exception {


    ApplicationContext context = new ClassPathXmlApplicationContext("classpath:app-config.xml");

    TomcatConfigurer configurer = context.getBean(TomcatConfigurer.class);
    configurer.start();

    /*String webappDirLocation = "src/main/webapp/";
    Tomcat tomcat = new Tomcat();

    //The port that we should run on can be set into an environment variable
    //Look for that variable and default to 8080 if it isn't there.
    String webPort = System.getenv("PORT");
    if (webPort == null || webPort.isEmpty()) {
      webPort = "8080";
    }

    tomcat.setPort(Integer.valueOf(webPort));

    StandardContext ctx = (StandardContext) tomcat.addWebapp("/", new File(webappDirLocation).getAbsolutePath());
    System.out.println("configuring app with basedir: " + new File("./" + webappDirLocation).getAbsolutePath());

    // Declare an alternative location for your "WEB-INF/classes" dir
    // Servlet 3.0 annotation will work
    File additionWebInfClasses = new File("target/classes");
    WebResourceRoot resources = new StandardRoot(ctx);
    resources.addPreResources(new DirResourceSet(resources, "/WEB-INF/classes",
      additionWebInfClasses.getAbsolutePath(), "/"));
    ctx.setResources(resources);

    tomcat.start();
    tomcat.getServer().await();*/
  }
}
