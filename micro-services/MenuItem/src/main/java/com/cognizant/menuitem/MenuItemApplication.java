package com.cognizant.menuitem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
public class MenuItemApplication {

	public static void main(String[] args) {
		SpringApplication.run(MenuItemApplication.class, args);
	}

}
