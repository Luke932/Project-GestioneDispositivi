package luke932.gestioneDispositivi.controllers;

import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import luke932.gestioneDispositivi.entities.Utente;
import luke932.gestioneDispositivi.service.UtenteService;

@RestController
@RequestMapping("/utenti")
public class UtenteController {

	@Autowired
	private UtenteService utenteService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@GetMapping
	public List<Utente> getAllUtenti() {
		return utenteService.getAllUtenti();
	}

	@GetMapping("/{id}")
	public Utente getUtenteById(@PathVariable UUID id) {
		return utenteService.getUtenteById(id);
	}

	@PostMapping
	public Utente createUtente(@RequestBody Utente utente) {
		return utenteService.createUtente(utente);
	}

	@PutMapping("/{id}")
	public Utente updateUtente(@PathVariable UUID id, @RequestBody Utente utente) {
		return utenteService.updateUtente(id, utente);
	}

	@DeleteMapping("/{id}")
	public void deleteUtente(@PathVariable UUID id) {
		utenteService.deleteUtente(id);
	}

	@PostMapping("/random")
	public Utente createRandomUtente() {
		Utente utente = createRandomUtenteData(); // Create a new user with random data
		return utenteService.createUtente(utente);
	}

	private Utente createRandomUtenteData() {
		String[] nomi = { "Marco", "Luca", "Anna", "Sara", "Marta" };
		String[] cognomi = { "Rossi", "Verdi", "Bianchi", "Neri", "Gialli" };
		String[] emails = { "marco@example.com", "luca@example.com", "anna@example.com", "sara@example.com",
				"marta@example.com" };

		Random random = new Random();
		String nome = nomi[random.nextInt(nomi.length)];
		String cognome = cognomi[random.nextInt(cognomi.length)];
		String email = emails[random.nextInt(emails.length)];

		Utente utente = new Utente();
		utente.setUsername(nome.toLowerCase() + "." + cognome.toLowerCase());
		utente.setNome(nome);
		utente.setCognome(cognome);
		utente.setEmail(email);
		// Generate a random password; use a secure password generator library in
		// production
		String password = RandomStringUtils.randomAlphanumeric(10);
		utente.setPassword(passwordEncoder.encode(password));

		return utente;
	}
}
