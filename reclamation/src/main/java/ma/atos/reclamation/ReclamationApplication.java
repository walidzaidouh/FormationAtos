package ma.atos.reclamation;

import ma.atos.reclamation.Models.Client;
import ma.atos.reclamation.Repositories.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ReclamationApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReclamationApplication.class, args);
	}
	@Bean
	CommandLineRunner start(ClientRepository client_repo) {
		return args -> {
			client_repo.deleteAll();
			Client user1 = new Client((long)1, "BE81468", (long)25054, "link_avatar1.jpg");
			client_repo.save(user1);



		};
	}
}
