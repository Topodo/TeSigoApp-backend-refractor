package com.edutools.tesigoapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.edutools.tesigoapp", "com.edutools.tesigoapp.rest"})
@EntityScan("com.edutools.tesigoapp.Entities")
@EnableJpaRepositories("com.edutools.tesigoapp.repositories")
public class TesigoappApplication {

	public static void main(String[] args) {
		SpringApplication.run(TesigoappApplication.class, args);
	}

}
