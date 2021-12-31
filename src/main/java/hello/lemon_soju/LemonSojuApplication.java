package hello.lemon_soju;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LemonSojuApplication {

	public static void main(String[] args) {
		SpringApplication.run(LemonSojuApplication.class, args);
		System.out.println("Hello I am Slave-01");
	}

}
