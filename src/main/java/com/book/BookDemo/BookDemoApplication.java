package com.book.BookDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class BookDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookDemoApplication.class, args);
	}

}
