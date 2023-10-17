package taller2.entrega.taller2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication(scanBasePackages = "taller2.entrega.taller2")
public class Taller2Application {
	public static void main(String[] args) {
		SpringApplication.run(Taller2Application.class, args);
	}
}
