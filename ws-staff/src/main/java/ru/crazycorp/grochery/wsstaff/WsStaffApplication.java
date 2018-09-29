package ru.crazycorp.grochery.wsstaff;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WsStaffApplication {
	public static void main(String[] args) {

	    // http://localhost:9050/ws-staff/employee?wsdl
		SpringApplication.run(WsStaffApplication.class, args);
	}
}
