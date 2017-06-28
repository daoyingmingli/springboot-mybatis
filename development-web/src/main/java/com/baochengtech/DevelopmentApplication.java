package com.baochengtech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;

@ComponentScan
@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class DevelopmentApplication {

	@RequestMapping("/")
	public String home() {
		return "redirect:/index";
	}

	public static void main(String[] args) {
		SpringApplication.run(DevelopmentApplication.class, args);

	}
}
