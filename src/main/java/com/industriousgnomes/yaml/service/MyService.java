package com.industriousgnomes.yaml.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@Configuration
//@PropertySource(name = "myProperties2", value = "classpath:application.yml")
@PropertySource(name = "myProperties2", value = {"myService.yml", "application.yml"})
public class MyService {

    @Value("${myproperties.prop1:myDefault1}")
    private String prop1;

    @Value("${myproperties.prop2:myDefault1}")
    private String prop2;

    @Value("${service.myprop1}")
    private String myprop1;

    @Value("${service.myprop2}")
    private String myprop2;

    public void execute() {
        System.out.println(prop1);
        System.out.println(prop2);
        System.out.println(myprop1);
        System.out.println(myprop2);
    }
}
