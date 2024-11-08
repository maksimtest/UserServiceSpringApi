package comparus.service.domain;


//import jakarta.persistence.Entity;
//import jakarta.persistence.Id;
//import jakarta.persistence.Table;
import lombok.*;

import javax.annotation.processing.Generated;

//@Entity
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
