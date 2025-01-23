package com.foodcourt.foodcourtmicro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class FoodcourtmicroApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodcourtmicroApplication.class, args);
	}

}
