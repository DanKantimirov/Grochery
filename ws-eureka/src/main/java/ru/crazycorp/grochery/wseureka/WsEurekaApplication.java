package ru.crazycorp.grochery.wseureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class WsEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(WsEurekaApplication.class, args);
	}
}
