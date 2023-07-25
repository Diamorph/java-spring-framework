package com.diamorph.learnspringframework.examples.h1;

import com.diamorph.learnspringframework.game.GameRunner;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class XmlConfigurationContextLauncherApplication {

    public static void main(String[] args) {

        try(
            ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("contextConfiguration.xml")) {
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
            System.out.println(context.getBean("name"));
            System.out.println(context.getBean("age"));
            System.out.println(context.getBean("game"));
            System.out.println(context.getBean("gameRunner"));
            context.getBean(GameRunner.class).run();

        }
    }
}
