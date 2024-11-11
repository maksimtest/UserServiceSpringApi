package comparus.service.configuration;

import comparus.service.domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DataSourceDetails {
    private String name;
    private String strategy;
    private String url;
    private String table;
    private String user;
    private String password;
    private DataSourceMapping mapping;

    public JdbcTemplate getJdbcTemplate() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        switch (strategy.toLowerCase()) {
            case "mysql":
                dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
                break;
            case "oracle":
                dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
                break;
            case "postgresql":
                dataSource.setDriverClassName("org.postgresql.Driver");
                break;
        }
        return new JdbcTemplate(dataSource);
    }
    @ToString.Exclude
    private RowMapper<User> userRowMapper = (rs, rowNum) -> {
        User user = new User();
        user.setId(rs.getString(mapping.getId()));
        user.setUsername(rs.getString(mapping.getUsername()));
        user.setName(rs.getString(mapping.getName()));
        user.setSurname(rs.getString(mapping.getSurname()));
        return user;
    };
    public String getFieldNameForFilter(String fieldName) {
        switch (fieldName.toLowerCase()) {
            case "id": return mapping.getId();
            case "username": return mapping.getUsername();
            case "name": return mapping.getName();
            case "surname": return mapping.getSurname();
        }
        return mapping.getId();
    }
}

