package comparus.service.config;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


import java.util.HashMap;
import java.util.Map;

//@Component
@Configuration
@Data
@NoArgsConstructor
@AllArgsConstructor
@ConfigurationProperties(prefix = "")
public class DataSourcesHolder {
    private Map<String, DataSourceDetails> dataSources = new HashMap<>();

}
