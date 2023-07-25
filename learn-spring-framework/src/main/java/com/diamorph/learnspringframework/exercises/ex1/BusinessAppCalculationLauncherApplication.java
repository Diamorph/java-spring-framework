package com.diamorph.learnspringframework.exercises.ex1;

import com.diamorph.learnspringframework.exercises.ex1.dataservice.BusinessCalculationService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
@ComponentScan
public class BusinessAppCalculationLauncherApplication {

    public static void main(String[] args) {
        try(
            AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BusinessAppCalculationLauncherApplication.class)
        ) {
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

            BusinessCalculationService businessCalculationService = context.getBean(BusinessCalculationService.class);
            System.out.println(businessCalculationService.findMax());
        }
    }
}
