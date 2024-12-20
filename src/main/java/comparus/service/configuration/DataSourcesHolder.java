package comparus.service.configuration;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


import java.util.HashMap;
import java.util.Map;

@Configuration
@Data
@NoArgsConstructor
@AllArgsConstructor
@ConfigurationProperties(prefix = "")
@Slf4j
public class DataSourcesHolder {
    private Map<String, DataSourceDetails> dataSources = new HashMap<>();

    @PostConstruct
    public void init() {
        dataSources.forEach((key, value) -> {value.setName(key);});
        dataSources.entrySet().forEach(d->log.debug("dataSource: "+d));
    }
}
