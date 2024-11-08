package comparus.service.controller;

import comparus.service.domain.User;
//import comparus.service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
//    private final UserRepository userRepository;
//
//    public UserController(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }

    @GetMapping("/users")
    public List<User> getUsersByFilters(
            @RequestParam(value = "order", required = false) String order,
            @RequestParam(value = "filter", required = false) String filter,
            @RequestParam(value = "backet", required = false) String backet) {
        System.out.println("/users: order=" + order + " filter=" + filter + " backet=" + backet);

        List<User> users = new ArrayList<>();//userRepository.findAll();
        return users;
    }
}
