package luke932.gestioneDispositivi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import luke932.gestioneDispositivi.entities.Dispositivo;
import luke932.gestioneDispositivi.entities.EType;
import luke932.gestioneDispositivi.repository.DispositivoRepository;

@Service
public class DispositivoService {

	@Autowired
	private DispositivoRepository dispositivoRepository;

	public List<Dispositivo> getAllDispositivi() {
		return dispositivoRepository.findAll();
	}

	public Dispositivo getDispositivoById(Long id) {
		return dispositivoRepository.getById(id);
	}

	public Dispositivo createDispositivo(Dispositivo dispositivo) {
		return dispositivoRepository.save(dispositivo);
	}

	public Dispositivo updateDispositivo(Long id, Dispositivo dispositivo) {
		Dispositivo existingDispositivo = getDispositivoById(id);
		existingDispositivo.setTipologia(dispositivo.getTipologia());
		existingDispositivo.setStato(dispositivo.getStato());
		return dispositivoRepository.save(existingDispositivo);
	}

	public void deleteDispositivo(Long id) {
		Dispositivo dispositivo = getDispositivoById(id);
		dispositivoRepository.delete(dispositivo);
	}

	public List<Dispositivo> getDispositiviByStato(String stato) {
		return dispositivoRepository.findByStato(stato);
	}

	public List<Dispositivo> getDispositiviByTipo(EType tipo) {
		return dispositivoRepository.findByTipologia(tipo);
	}
}
