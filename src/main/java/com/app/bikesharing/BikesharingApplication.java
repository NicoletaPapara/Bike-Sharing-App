package com.app.bikesharing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.TimeZone;

@SpringBootApplication
public class BikesharingApplication {

	public static void main(String[] args) {
		SpringApplication.run(BikesharingApplication.class, args);
	}

	public BikesharingApplication() {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	}


}
