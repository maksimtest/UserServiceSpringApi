package comparus.service.configuration;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DataSourceMapping {
    private String id;
    private String username;
    private String name;
    private String surname;
}