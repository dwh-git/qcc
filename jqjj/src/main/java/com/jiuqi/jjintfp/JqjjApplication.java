package com.jiuqi.jjintfp;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class JqjjApplication {

	public static void main(String[] args) {
		SpringApplication.run(JqjjApplication.class, args);
	}
}
