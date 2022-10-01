package br.com.bancomundial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"br.com.bancomundial"})
@EnableFeignClients(basePackages = {"br.com.bancomundial.gateway"})
public class BancomundialApplication {

	public static void main(String[] args) {
		SpringApplication.run(BancomundialApplication.class, args);
	}

}
