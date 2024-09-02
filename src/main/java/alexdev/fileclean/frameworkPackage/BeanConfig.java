package alexdev.fileclean.frameworkPackage;

import alexdev.fileclean.cleanPackage.FileWriterManagerService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    FileWriterManagerService fileWriterManagerService() {
        return new FileWriterManagerService();
    }

}
