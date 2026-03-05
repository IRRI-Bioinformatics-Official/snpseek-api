package org.irri.snpseek;

import org.slf4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SnpseekAPIApplication {
	private static Logger logger;

	public static void main(String[] args) {
		SpringApplication.run(SnpseekAPIApplication.class, args);
	}
}