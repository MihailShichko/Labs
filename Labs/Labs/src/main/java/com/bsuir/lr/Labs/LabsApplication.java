package com.bsuir.lr.Labs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
public class LabsApplication {
	public static void main(String[] args) {
		String con = "jdbc:sqlserver:desktop-arbq8s0\\lenovo;databaseName=test";

		SpringApplication.run(LabsApplication.class, args);
	}

}
