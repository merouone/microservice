

package com.app.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
/**
*
* @summary  The main entry to run the standalone microservice that exposes a Rest API.
*
* @author      Merouane
* @version     %I%, %G%
* @since       1.0
*/
public class MainApp {

	/**
	 * Main entry of the application
	 * @param args
	 */
	public static void main(String[] args) {

		SpringApplication.run(MainApp.class, args);
	}

}
