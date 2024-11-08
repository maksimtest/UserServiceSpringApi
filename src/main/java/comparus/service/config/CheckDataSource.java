package comparus.service.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class CheckDataSource implements ApplicationRunner {
    private DataSourcesHolder dataSourcesHolder;

    @Autowired
    public CheckDataSource(DataSourcesHolder dataSourcesHolder) {
        this.dataSourcesHolder = dataSourcesHolder;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("readConfig.getDataSources()="+dataSourcesHolder.getDataSources());
    }
}
