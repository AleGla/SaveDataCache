package com.ar.alegla;

import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ar.alegla.model.Request;

@SpringBootApplication
public class SavedataCacheApplication {
	
	@Bean
	public ArrayList<Request> dataList(){
		return new ArrayList<Request>();
	}
	

	public static void main(String[] args) {
		SpringApplication.run(SavedataCacheApplication.class, args);
	}

}
