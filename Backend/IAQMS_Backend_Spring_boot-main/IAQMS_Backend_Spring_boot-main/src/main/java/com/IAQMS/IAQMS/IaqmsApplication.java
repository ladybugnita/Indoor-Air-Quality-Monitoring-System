package com.IAQMS.IAQMS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class IaqmsApplication {

	public static void main(String[] args) throws Exception{
		ConfigurableApplicationContext context = SpringApplication.run(IaqmsApplication.class, args);
		System.out.println("App is running");

		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver loaded!");
		Thread.currentThread().join();
	}

}
