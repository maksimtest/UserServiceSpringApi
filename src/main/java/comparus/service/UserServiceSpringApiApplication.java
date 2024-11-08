package comparus.service;

import comparus.service.config.DataSourcesHolder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(DataSourcesHolder.class)
public class UserServiceSpringApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceSpringApiApplication.class, args);
    }

}
