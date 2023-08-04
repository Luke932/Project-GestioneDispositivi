package luke932.gestioneDispositivi.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import luke932.gestioneDispositivi.entities.Utente;
import luke932.gestioneDispositivi.payload.UserRequestPayload;

public interface UserRepository extends JpaRepository<Utente, Long> {

	Utente findByEmail(String email);

	Optional<Utente> findByUsernameOrEmail(String username, String email);

	Optional<Utente> findByUsername(String username);

	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);

	Optional<Utente> findById(UUID uuid);

	Utente save(UserRequestPayload body);

}
