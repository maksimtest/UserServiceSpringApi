package comparus.service.service;

import comparus.service.configuration.DataSourcesHolder;
import comparus.service.domain.User;
import comparus.service.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.mockito.Mockito.when;
import org.mockito.Mockito;

class UserServiceTest {
    private static UserService userService;
    private static final List<User> mockUsers = new ArrayList<>();
    private static final Map<String, Integer> propagationCases = new HashMap<>();

    @BeforeAll
    public static void init() {
        userService = Mockito.spy(new UserService(new UserRepository(), new ValidateRequestParameters(), new DataSourcesHolder()));
        for (int i = 0; i < 10; i++) {
            int p = (int)'a' + i;
            String v = (char)p + "";
            mockUsers.add(new User(v, v, v, v));
        }
        propagationCases.put("0-10", 10);
        propagationCases.put("0-11", 10);
        propagationCases.put("0-4", 4);
        propagationCases.put("1-4", 4);
        propagationCases.put("2-4", 2);
        propagationCases.put("3-4", 0);
        propagationCases.put("0-8", 8);
        propagationCases.put("1-8", 2);
        propagationCases.put("2-8", 0);

    }
    @Test
    void checkOrderField1() {
        when(userService.readUsersFromDataSourceHolderByFilter("")).thenReturn(mockUsers);

        String order = "name";
        List<User> users = userService.getUsersByFilters("","", order);
        String actual = users.stream().map(User::getName).collect(Collectors.joining(","));
        String expected = "a,b,c,d,e,f,g,h,i,j";
        Assertions.assertEquals(actual, expected, "userService.getUsersByFilters with order="+order+" return "+actual+" but should return "+expected);
    }
    @Test
    void checkOrderField2() {
        when(userService.readUsersFromDataSourceHolderByFilter("")).thenReturn(mockUsers);

        String order = "-name";
        List<User> users = userService.getUsersByFilters("","", order);
        String actual = users.stream().map(User::getName).collect(Collectors.joining(","));
        String expected = "j,i,h,g,f,e,d,c,b,a";
        Assertions.assertEquals(actual, expected, "userService.getUsersByFilters with order="+order+" return "+actual+" but should return "+expected);
    }
    @Test
    void checkPropagationField() {
        when(userService.readUsersFromDataSourceHolderByFilter("")).thenReturn(mockUsers);
        for(Map.Entry<String, Integer> entry : propagationCases.entrySet()){
            String propagation = entry.getKey();
            int expected = entry.getValue();
            int actual = userService.getUsersByFilters("",propagation, "").size();

            Assertions.assertEquals(actual, expected, "userService.getUsersByFilters with propagation="+propagation+" return "+actual+" but should return "+expected);
        }
    }
}