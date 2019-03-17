package com.uaic.bankTrx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class BankTrxApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankTrxApplication.class, args);
	}

}
