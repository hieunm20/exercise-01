package com.educa.vn;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class Exercise01Application implements CommandLineRunner {

	@Value("${application.host}")
	private String host;

	@Value("${application.port}")
	private Integer port;

	public static void main(String[] args) {
		SpringApplication.run(Exercise01Application.class, args);
	}

	public void run(String... strings) throws Exception {
		log.info("(Exercise01Application) host: {}", host);
		log.info("(Exercise01Application) port: {}", port);
	}
}
