package com.tp1.projet1;

import com.tp1.projet1.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class )
public class Projet1Application implements WebMvcConfigurer {

	public void addViewController(ViewControllerRegistry registry){
		registry.addViewController("/home").setViewName("home");
	}
	public static void main(String[] args) {
		SpringApplication.run(Projet1Application.class, args);
	}

}
