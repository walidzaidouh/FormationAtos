package ma.atos.reclamation;

import ma.atos.reclamation.Models.Client;
import ma.atos.reclamation.Models.Reclamation;
import ma.atos.reclamation.Repositories.ClientRepository;
import ma.atos.reclamation.Repositories.ReclamationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class ReclamationApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReclamationApplication.class, args);
	}
	@Bean
	CommandLineRunner start(ReclamationRepository reclamationRepository) {
		return args -> {
			//reclamationRepository.deleteAll();
			Date date_now = new Date();
			Reclamation reclamation = new Reclamation("1221", "urgent", date_now, "gestionaire", "boody");
			reclamationRepository.save(reclamation);
		};
	}
}
