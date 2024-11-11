package comparus.service.service;

import comparus.service.configuration.DataSourceDetails;
import comparus.service.configuration.DataSourcesHolder;
import comparus.service.domain.User;
import comparus.service.exception.FilterInvalidParametersException;
import comparus.service.exception.OrderInvalidParametersException;
import comparus.service.exception.PropagationInvalidParametersException;
import comparus.service.util.StringUtil;
import comparus.service.util.UserComparator;
import comparus.service.exception.InvalidParametersException;
import comparus.service.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class UserService {
    private final UserRepository userRepository;
    private final ValidateRequestParameters validateRequestParameters;
    private final DataSourcesHolder dataSourcesHolder;

    public List<User> getUsersByFilters(String filter, String propagation, String order) throws InvalidParametersException {
        validateRequestParameters.checkFilterField(filter);
        validateRequestParameters.checkPropagationField(propagation);
        validateRequestParameters.checkOrderField(order);

        List<User> allUsers = readUsersFromDataSourceHolderByFilter(filter);
        if (order != null && !order.isEmpty()) {
            allUsers.sort(new UserComparator(order));
        }
        if (propagation != null && !propagation.isEmpty()) {
            int numberOfBacket = StringUtil.getFirstNumberBySeparator(propagation, "-");
            int countInBacket = StringUtil.getSecondNumberBySeparator(propagation, "-");
            return allUsers.stream().skip((long) numberOfBacket * countInBacket).limit(countInBacket).toList();
        }
        return allUsers;
    }
    // this method present separate from getUsersByFilters for UserServiceTest class
    protected List<User> readUsersFromDataSourceHolderByFilter(String filter){
        List<User> allUsers = new ArrayList<>();
        for (DataSourceDetails dataSource : dataSourcesHolder.getDataSources().values()) {
            try {
                log.debug("analyze: dataSource: " + dataSource.getName());
                List<User> users = userRepository.getUsersByFilter(dataSource, filter);
                log.debug("read from dataSource: users.size()=" + users.size());
                allUsers.addAll(users);
            } catch (Exception e) {
                log.error("Invalid connection to "+dataSource+" with message: "+e.getMessage());
            }
        }
        return allUsers;
    }
}
