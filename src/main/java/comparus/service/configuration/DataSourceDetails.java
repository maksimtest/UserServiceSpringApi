package comparus.service.configuration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
}
