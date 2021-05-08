package com.mycompany.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@SpringBootApplication
public class SpringWebHelloworldJspApplication {

	private static final Logger logger = LoggerFactory.getLogger(SpringWebHelloworldJspApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(SpringWebHelloworldJspApplication.class, args);
		
		 logger.info("this is a info message");
	      logger.warn("this is a warn message");
	      logger.error("this is a error message");
	}

}
