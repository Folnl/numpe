package br.com.numpetest.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.numpetest.api.helpers.DatabaseBootstrap;

@SpringBootApplication
public class ApiApplication implements CommandLineRunner {

	@Autowired
	private DatabaseBootstrap databaseBootstrap;

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		databaseBootstrap.bootstrapFuelingOrders();
	}
}
