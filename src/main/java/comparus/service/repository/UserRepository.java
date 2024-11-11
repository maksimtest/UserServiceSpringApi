package comparus.service.repository;

import comparus.service.configuration.DataSourceDetails;
import comparus.service.domain.User;
import comparus.service.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Slf4j
public class UserRepository {

    private List<User> getUsers(DataSourceDetails dataSourceDetails) {
        String tableName = dataSourceDetails.getTable();
        String sql = String.format("SELECT * FROM %s", tableName);

        log.debug("getUsers: sql=" + sql);
        JdbcTemplate jdbcTemplate = dataSourceDetails.getJdbcTemplate();

        return jdbcTemplate.query(sql,
                dataSourceDetails.getUserRowMapper());
    }

    public List<User> getUsersByFilter(DataSourceDetails dataSourceDetails, String filter) {
        if (filter == null || filter.isEmpty()) {
            return getUsers(dataSourceDetails);
        }
        String tableName = dataSourceDetails.getTable();

        String filterFieldName = StringUtil.getFirstPartOfString(filter, "-");
        filterFieldName = dataSourceDetails.getFieldNameForFilter(filterFieldName);
        String filterValue = StringUtil.getSecondPartOfString(filter, "-");
        log.debug("getUsersByFilter, tableName: {}, filterFieldName: {}, filterValue: {}", tableName, filterFieldName, filterValue);

        String sql = String.format("SELECT * FROM %s WHERE %s LIKE ?", tableName, filterFieldName);
        log.debug("getUsersByFilter: sql=" + sql);
        JdbcTemplate jdbcTemplate = dataSourceDetails.getJdbcTemplate();

        return jdbcTemplate.query(sql,
                dataSourceDetails.getUserRowMapper(),
                new Object[]{"%" + filterValue + "%"});
    }
}
