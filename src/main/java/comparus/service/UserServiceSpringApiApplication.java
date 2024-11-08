package comparus.service;

import comparus.service.config.ReadConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(ReadConfig.class)
public class UserServiceSpringApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceSpringApiApplication.class, args);
    }

}
