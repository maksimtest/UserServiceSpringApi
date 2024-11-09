package comparus.service.service;

import comparus.service.configuration.DataSourceDetails;
import comparus.service.configuration.DataSourcesHolder;
import comparus.service.domain.User;
import comparus.service.util.StringUtil;
import comparus.service.util.UserComparator;
import comparus.service.exception.InvalidParametersException;
import comparus.service.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final ValidateRequestParameters validateRequestParameters;
    private final DataSourcesHolder dataSourcesHolder;

    // this method present separate for UserServiceTest class
    protected List<User> readUsersFromDataSourceHolderByFilter(String filter){
        List<User> allUsers = new ArrayList<>();
        for (DataSourceDetails dataSource : dataSourcesHolder.getDataSources().values()) {
            allUsers.addAll(userRepository.getUsersByFilter(dataSource, filter));
        }
        return allUsers;
    }
    public List<User> getUsersByFilters(String filter, String propagation, String order) {
        validateRequestParameters.checkFilterField(filter);
        validateRequestParameters.checkPropagationField(propagation);
        validateRequestParameters.checkOrderField(order);

        List<User> allUsers = readUsersFromDataSourceHolderByFilter(filter);
        if (order != null && !order.isEmpty()) {
            Collections.sort(allUsers, new UserComparator(order));
        }
        if (propagation != null && !propagation.isEmpty()) {
            int numberOfBacket = StringUtil.getFirstNumberByString(propagation, "-");
            int countInBacket = StringUtil.getSecondNumberByString(propagation, "-");
            List<User> users = allUsers.stream().skip(numberOfBacket * countInBacket).limit(countInBacket).toList();
            return users;
        }
        return allUsers;
    }

    @ExceptionHandler(InvalidParametersException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected String handleCustomException(InvalidParametersException ex) {
        return ex.getMessage();
    }
}
