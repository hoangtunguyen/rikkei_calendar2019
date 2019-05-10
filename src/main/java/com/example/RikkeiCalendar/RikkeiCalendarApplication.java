package com.example.RikkeiCalendar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan( basePackages = {"com.example.RikkeiCalendar.entity"} )
@EnableJpaRepositories(basePackages = {"com.example.RikkeiCalendar.repository"})
public class RikkeiCalendarApplication {
	public static void main(String[] args) {
		SpringApplication.run(RikkeiCalendarApplication.class, args);
	}

}
