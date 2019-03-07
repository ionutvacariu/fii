package eu.unicredit.fii.practic.fii.init;

import eu.unicredit.fii.practic.fii.model.User;
import eu.unicredit.fii.practic.fii.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(UserRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new User("Bilbo Baggins", 5_000D)));
            log.info("Preloading " + repository.save(new User("Frodo Baggins", 3_500D)));
        };
    }
}
