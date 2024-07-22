package com.josiasdasilva.agiletestrestfulapi;

import org.springframework.boot.SpringApplication;

public class TestAgiletestrestfulapiApplication {

	public static void main(String[] args) {
		SpringApplication.from(AgiletestrestfulapiApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
