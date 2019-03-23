package com.uaic.bankTrx.init;

import com.uaic.bankTrx.model.User;
import com.uaic.bankTrx.model.UserLoginInfo;
import com.uaic.bankTrx.repository.UserLoginRepository;
import com.uaic.bankTrx.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class LoadDatabase {
	//@Bean
	CommandLineRunner initDatabase(UserRepository userRepository ,UserLoginRepository repository) {
		return args -> {

			final UserLoginInfo userLoginInfo = new UserLoginInfo("batman", "admin", "USER");
			//repository.save(userLoginInfo);
			final User batman = new User("Batman", 500000.0, userLoginInfo);
			userRepository.save(batman);

			final UserLoginInfo userLoginInfo2 = new UserLoginInfo("arnold", "admin",  "USER");
			final User arnold_schwarzneger = new User("Arnold Schwarzneger", 50000.0, userLoginInfo2);
			userRepository.save(arnold_schwarzneger);
		};
	}
}
