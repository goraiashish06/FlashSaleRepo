package com.flash.flashsale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages="com.flash.flashsale")
public class FlashsaleApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlashsaleApplication.class, args);
	}

}
