package net.kraklups.photonwell.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource({"classpath:spring-config.xml"})
public class DataValueAppConfig {

	static final Logger logger = LoggerFactory.getLogger(DataValueAppConfig.class);
	
	public static void main(String[] args) {
		
		logger.info("Starting DataValue REST Service"); 
		
		SpringApplication.run(DataValueAppConfig.class, args);
		
	}

}
