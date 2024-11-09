package comparus.service.controller;

import comparus.service.domain.User;
//import comparus.service.repository.UserRepository;
import comparus.service.service.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
//@RequiredArgsConstructor
public class UserController {
    private final UserService userService;


    @GetMapping("/users")
    public List<User> getUsersByFilters(
            @RequestParam(value = "order", required = false) String order,
            @RequestParam(value = "filter", required = false) String filter,
            @RequestParam(value = "backet", required = false) String backet) {

        List<User> users = userService.getUsersByFilters(filter, backet, order);

        return users;
    }
}
