package com.example.btech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"com.example.btech"})
public class BtechApplication {

	public static void main(String[] args) {
		SpringApplication.run(BtechApplication.class, args);
	}

}
