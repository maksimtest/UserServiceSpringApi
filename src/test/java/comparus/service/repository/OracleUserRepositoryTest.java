package comparus.service.repository;

import comparus.service.configuration.DataSourceDetails;
import comparus.service.configuration.DataSourceMapping;
import comparus.service.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.oracle.OracleContainer;
import org.testcontainers.utility.DockerImageName;

import java.util.List;

@Testcontainers
@SpringBootTest
public class OracleUserRepositoryTest {

    private final UserRepository userRepository;
    @Autowired
    public OracleUserRepositoryTest(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private final DriverManagerDataSource dataSource = new DriverManagerDataSource();
    private final DataSourceDetails dataSourceDetails = new DataSourceDetails();
    private final User user = new User();

    @Container
    private static final OracleContainer db = new OracleContainer("gvenzl/oracle-free:slim-faststart");

    @BeforeEach
    void setUp() {
        db.start();
        dataSource.setUrl(db.getJdbcUrl());
        dataSource.setUsername(db.getUsername());
        dataSource.setPassword(db.getPassword());
        dataSource.setDriverClassName(db.getDriverClassName());

        dataSourceDetails.setUrl(db.getJdbcUrl());
        dataSourceDetails.setName("test");
        dataSourceDetails.setStrategy("mysql");
        dataSourceDetails.setTable("user_table");
        dataSourceDetails.setUser(db.getUsername());
        dataSourceDetails.setPassword(db.getPassword());

        DataSourceMapping dataSourceMapping = new DataSourceMapping();
        dataSourceDetails.setMapping(dataSourceMapping);
        dataSourceMapping.setId("id");
        dataSourceMapping.setUsername("username");
        dataSourceMapping.setName("name");
        dataSourceMapping.setSurname("surname");

        user.setId("id1");
        user.setUsername("username1");
        user.setName("name1");
        user.setSurname("surname1");
    }

    @Test
    void getUsersByFilters() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String table = dataSourceDetails.getTable();
        String columns = dataSourceDetails.getMapping().toString();

        jdbcTemplate.update("CREATE TABLE IF NOT EXISTS "+table+
                "("+
                            dataSourceDetails.getMapping().getId()+" character varying(250),"+
                            dataSourceDetails.getMapping().getUsername()+" character varying(250),"+
                            dataSourceDetails.getMapping().getName()+" character varying(250),"+
                            dataSourceDetails.getMapping().getSurname()+" character varying(250),"+
                "PRIMARY KEY ("+dataSourceDetails.getMapping().getId()+
                "))");

        jdbcTemplate.update("INSERT INTO "+table+" ("+columns+") VALUES (?,?,?,?)",
                user.getId(),
                user.getUsername(),
                user.getName(),
                user.getSurname());

        List<User> users = userRepository.getUsersByFilter(dataSourceDetails, "");

        Assertions.assertEquals(users.size(), 1, "Wrong number of users");
        Assertions.assertEquals(user, users.get(0), "Wrong users: expected: " + user + ", actual: " + users.get(0));
    }
}