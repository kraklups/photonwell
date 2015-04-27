package net.kraklups.photonwell.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource({"classpath:spring-config.xml"})
public class DataValueAppConfig extends SpringBootServletInitializer {

	static final Logger logger = LoggerFactory.getLogger(DataValueAppConfig.class);
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(DataValueAppConfig.class);
	}        
	
	public static void main(String[] args) {
		
		logger.info("Starting DataValue REST Service"); 
		
		SpringApplication.run(DataValueAppConfig.class, args);
		
	}

}
