package comparus.service.configuration;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DataSourceMapping {
    private String id;
    private String username;
    private String name;
    private String surname;

    public String toString(){
        return id + ", " + username + ", " + name + ", " + surname;
    }
}