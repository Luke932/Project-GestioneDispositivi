package luke932.gestioneDispositivi.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import luke932.gestioneDispositivi.entities.Utente;
import luke932.gestioneDispositivi.payload.UserRequestPayload;
import luke932.gestioneDispositivi.repository.UserRepository;

@Service
public class UtenteService {

	@Autowired
	private UserRepository utenteRepository;

	public List<Utente> getAllUtenti() {
		return utenteRepository.findAll();
	}

	public Utente getUtenteById(UUID uuid) {
		return utenteRepository.findById(uuid)
				.orElseThrow(() -> new NoSuchElementException("Utente non trovato con ID: " + uuid));
	}

	public Utente createUtente(Utente utente) {
		return utenteRepository.save(utente);
	}

	public Utente updateUtente(UUID id, Utente utente) {
		Utente existingUtente = getUtenteById(id);
		existingUtente.setUsername(utente.getUsername());
		existingUtente.setNome(utente.getNome());
		existingUtente.setUsername(utente.getUsername());
		existingUtente.setEmail(utente.getEmail());
		return utenteRepository.save(existingUtente);
	}

	public void deleteUtente(UUID id) {
		Utente utente = getUtenteById(id);
		utenteRepository.delete(utente);
	}

	public Utente findByEmail(String email) {
		return utenteRepository.findByEmail(email);
	}

	public Optional<Utente> findByUsernameOrEmail(String username, String email) {
		return utenteRepository.findByUsernameOrEmail(username, email);
	}

	public Optional<Utente> findByUsername(String username) {
		return utenteRepository.findByUsername(username);
	}

	public Boolean existsByUsername(String username) {
		return utenteRepository.existsByUsername(username);
	}

	public Boolean existsByEmail(String email) {
		return utenteRepository.existsByEmail(email);
	}

	public Utente createUtente(UserRequestPayload body) {
		return utenteRepository.save(body);
	}

}
