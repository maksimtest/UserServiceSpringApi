package comparus.service.domain;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    // @Id
    private String id;
    private String username;
    private String name;
    private String surname;

}
