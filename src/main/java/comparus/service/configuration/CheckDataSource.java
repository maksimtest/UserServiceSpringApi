package comparus.service.configuration;

import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
//@RequiredArgsConstructor
@AllArgsConstructor
public class CheckDataSource implements ApplicationRunner {
    private DataSourcesHolder dataSourcesHolder;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("readConfig.getDataSources()="+dataSourcesHolder.getDataSources());
    }
}
