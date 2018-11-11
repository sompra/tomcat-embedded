package com.sompra.controller;

import com.sompra.configuration.tomcat.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by somprasong
 * Date: 10/11/2018
 * Time: 16:36
 */

@Controller
public class HelloController {

    @Autowired
    private AppConfig tomcatProperties;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public ResponseEntity printWelcome() {
        return new ResponseEntity(tomcatProperties, HttpStatus.ACCEPTED);

    }

    @RequestMapping(value = "/hello/{name}", method = RequestMethod.GET)
    public ResponseEntity hello(@PathVariable("name") String name) {

        return new ResponseEntity("Hello " + name, HttpStatus.ACCEPTED);

    }
}
