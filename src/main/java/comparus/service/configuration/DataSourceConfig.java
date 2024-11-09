package comparus.service.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
//@EnableTransactionManagement
public class DataSourceConfig {


    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUsername("postgres");

        dataSource.setPassword("root");
        dataSource.setUrl(
                "jdbc:postgresql://localhost:5432/comparus1");

        return dataSource;
    }

}
