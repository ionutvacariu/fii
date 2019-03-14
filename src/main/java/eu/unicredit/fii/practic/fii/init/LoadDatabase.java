package eu.unicredit.fii.practic.fii.init;

import eu.unicredit.fii.practic.fii.model.Login;
import eu.unicredit.fii.practic.fii.model.User;
import eu.unicredit.fii.practic.fii.repository.UserRepository;
import eu.unicredit.fii.practic.fii.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
class LoadDatabase {

    @Bean
    public CommandLineRunner setupDefaultUser(LoginService service) {
        return args -> {
            service.save(new Login(
                    "mylogin",
                    "mypass"
            ));
        };
    }

    @Bean
    CommandLineRunner initDatabase(UserRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new User("Bilbo Baggins", 5_000D)));
            log.info("Preloading " + repository.save(new User("Frodo Baggins", 3_500D)));
        };
    }
}
