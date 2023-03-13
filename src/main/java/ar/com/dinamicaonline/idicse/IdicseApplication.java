package ar.com.dinamicaonline.idicse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class IdicseApplication {

	public static void main(String[] args) {
		System.setProperty("javax.net.ssl.trustStore", "certificates/truststore.jks");
		System.setProperty("javax.net.ssl.trustStorePassword", "dinamica");
		SpringApplication.run(IdicseApplication.class, args);
	}

}
