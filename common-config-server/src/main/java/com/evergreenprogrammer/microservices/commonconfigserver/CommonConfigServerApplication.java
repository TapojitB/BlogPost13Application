package com.evergreenprogrammer.microservices.commonconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableDiscoveryClient(autoRegister = true)
@EnableConfigServer
@SpringBootApplication
public class CommonConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommonConfigServerApplication.class, args);
	}
}
