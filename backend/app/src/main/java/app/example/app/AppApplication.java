package app.example.app;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class AppApplication {

	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.configure().filename(".env").load();
		Dotenv dotenvDomain = Dotenv.configure().filename("domain.env").load();

		System.setProperty("AWS_ACCESS_KEY", dotenv.get("AWS_ACCESS_KEY"));
		System.setProperty("AWS_SECRET_KEY", dotenv.get("AWS_SECRET_KEY"));
		System.setProperty("DB_URL", dotenv.get("DB_URL"));
		System.setProperty("DB_USERNAME", dotenv.get("DB_USERNAME"));
		System.setProperty("DB_PASSWORD", dotenv.get("DB_PASSWORD"));
		System.setProperty("CROSS_ORIGIN", dotenvDomain.get("CROSS_ORIGIN"));
		SpringApplication.run(AppApplication.class, args);
	}

}
