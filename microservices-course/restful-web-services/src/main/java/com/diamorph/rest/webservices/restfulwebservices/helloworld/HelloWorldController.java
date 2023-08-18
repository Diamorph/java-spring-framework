package com.diamorph.rest.webservices.restfulwebservices.helloworld;


import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

// Rest API
@RestController
public class HelloWorldController {

    private final MessageSource messageSource;

    public HelloWorldController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @GetMapping("/hello-world")
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping("/hello-world-bean")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("Hello World!");
    }

    @GetMapping("/hello-world/path-variable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable("name") String name) {
        try {
            String uppercasedName = name.length() > 1 ?
                    name.substring(0, 1).toUpperCase() + name.substring(1) :
                    name.toUpperCase();
            return new HelloWorldBean(
                String.format("Hello World, %s", uppercasedName)
            );
        } catch (Exception e) {
            System.out.println("EXCEPTION: " + e);
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/hello-world-internationalized")
    public String helloWorldInternationalized() throws UnsupportedEncodingException {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("good.morning.message", null, "Default Message", locale);
    }
}
