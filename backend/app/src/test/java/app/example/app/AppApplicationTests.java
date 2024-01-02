package app.example.app;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = app.example.app.AppApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class AppApplicationTests {

	@Test
	void contextLoads() {
	}

}
