package desafio.springListToDo;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(
		title = "lista To Do",
		version = "1.2",
		description = "Back-end de uma aplicação da lista To Do com documentação e tratamentos de erro."))
public class SpringListToDoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringListToDoApplication.class, args);
	}

}
