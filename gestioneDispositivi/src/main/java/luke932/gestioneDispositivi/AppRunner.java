package luke932.gestioneDispositivi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import luke932.gestioneDispositivi.entities.Utente;
import luke932.gestioneDispositivi.service.UtenteService;

@Component
public class AppRunner implements CommandLineRunner {

	private final UtenteService utenteService;

	public AppRunner(UtenteService utenteService) {
		this.utenteService = utenteService;
	}

	@Override
	public void run(String... args) throws Exception {
		createRandomUsers();
	}

	private void createRandomUsers() {
		for (int i = 0; i < 10; i++) {
			Utente utente = new Utente();
			utente.setUsername("utente" + i);
			utente.setNome("Nome" + i);
			utente.setCognome("Cognome" + i);
			utente.setEmail("utente" + i + "@example.com");
			utente.setPassword("password" + i);

			utenteService.createUtente(utente);
		}
	}
}
