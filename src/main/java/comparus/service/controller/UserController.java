package comparus.service.controller;

import comparus.service.domain.User;
//import comparus.service.repository.UserRepository;
import comparus.service.exception.FilterInvalidParametersException;
import comparus.service.exception.InvalidParametersException;
import comparus.service.exception.OrderInvalidParametersException;
import comparus.service.exception.PropagationInvalidParametersException;
import comparus.service.service.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
public class UserController {
    private final UserService userService;

    @GetMapping("/users")
    public List<User> getUsersByFilters (
            @RequestParam(value = "order", required = false) String order,
            @RequestParam(value = "filter", required = false) String filter,
            @RequestParam(value = "propagation", required = false) String propagation) {
        log.info("User.controller.users, order="+order+", filter="+filter+", propagation="+propagation);
        List<User> users = userService.getUsersByFilters(filter, propagation, order);

        return users;
    }
    @ExceptionHandler({FilterInvalidParametersException.class, OrderInvalidParametersException.class, PropagationInvalidParametersException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected String handleCustomException(InvalidParametersException ex) {
        return ex.getMessage();
    }
}
