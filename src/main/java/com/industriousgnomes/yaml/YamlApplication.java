package com.industriousgnomes.yaml;

import com.industriousgnomes.yaml.service.MyService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;

@SpringBootApplication
@Configuration
@PropertySource(name = "myProperties", value = "application.yml")
public class YamlApplication {

    @Value("${myproperties.prop1:myDefault1}")
    private String prop1;

    @Value("${myproperties.prop2:myDefault1}")
    private String prop2;

    public static void main(String[] args) {
        SpringApplication.run(YamlApplication.class, args);
    }

    // **********************************
    // WARNING WARNING
    // **********************************
    // Although the PostCosntruct works, I cant get properties in other services to work
    // **********************************

    @PostConstruct
    public void afterInitalize() {
        Assert.isTrue(prop1.equals("Hello"), "Improper value");
        Assert.isTrue(prop2.equals("There"), "Improper value");

        MyService myService = new MyService();
        myService.execute();
    }
}
