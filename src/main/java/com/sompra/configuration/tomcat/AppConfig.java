package com.sompra.configuration.tomcat;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * Created by somprasong
 * Date: 10/11/2018
 * Time: 10:00
 */

@Configuration
public class AppConfig {

  @Value("${application.name}")
  String applicationName;

  public String getApplicationName() {
    return applicationName;
  }

  public void setApplicationName(String applicationName) {
    this.applicationName = applicationName;
  }
}
