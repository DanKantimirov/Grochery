package ru.crazycorp.grochery.wsproduct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController("ws-product")
public class WsProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(WsProductApplication.class, args);
	}

	@RequestMapping(value = "/getProductHello")
	public String getProductHello(){
		return "Hello from product service";
	}
}
