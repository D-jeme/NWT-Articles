package com.techprimers.db;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.techprimers.db.repository.PictureOfArticleRepository;
import com.techprimers.db.model.PictureOfArticle;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;

@EnableJpaRepositories(basePackages = "com.techprimers.db.repository")
@SpringBootApplication
public class SpringBootMysqldbApplication {
	public static void main(String[] args) {



		SpringApplication.run(SpringBootMysqldbApplication.class, args);
	}


}
