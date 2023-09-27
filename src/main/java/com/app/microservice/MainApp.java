

package com.app.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
/**
 *
 * @summary  The main entry to run the standalone microservice that exposes a Rest API.
 */
public class MainApp {

	public static void main(String[] args) {

		SpringApplication.run(MainApp.class, args);
	}

}
