package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import service.DBService;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private DBService dbService;

    @Bean
     public void instanciaBaseDeDados() {
        this.dbService.instanciaBaseDeDados();
    }

    @Override
    public void run(String... args) throws Exception {
        this.instanciaBaseDeDados();
    }
}
