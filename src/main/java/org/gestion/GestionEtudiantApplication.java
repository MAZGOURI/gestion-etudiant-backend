package org.gestion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.header.writers.StaticHeadersWriter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
//@ComponentScan({"org.gestion.dao", "org.gestion.controlle‌​r"})
//@EnableAutoConfiguration(exclude = {ErrorMvcAutoConfiguration.class})
public class GestionEtudiantApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionEtudiantApplication.class, args);
		System.out.println("server works!");
	}
}
