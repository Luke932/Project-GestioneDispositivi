package luke932.gestioneDispositivi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import luke932.gestioneDispositivi.entities.Dispositivo;
import luke932.gestioneDispositivi.entities.EType;

public interface DispositivoRepository extends JpaRepository<Dispositivo, Long> {
	List<Dispositivo> findByTipologia(EType tipo);

	List<Dispositivo> findByStato(String stato);

	Dispositivo getById(Long id);
}
