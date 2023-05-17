package com.yash.ytms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class YtmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(YtmsApplication.class, args);
		System.out.println("Wellcome to YTMS");
	}

}
