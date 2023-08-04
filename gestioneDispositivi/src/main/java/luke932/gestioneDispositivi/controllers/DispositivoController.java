package luke932.gestioneDispositivi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import luke932.gestioneDispositivi.entities.Dispositivo;
import luke932.gestioneDispositivi.entities.EType;
import luke932.gestioneDispositivi.service.DispositivoService;

@RestController
@RequestMapping("/dispositivi")
public class DispositivoController {

	@Autowired
	private DispositivoService dispositivoService;

	@GetMapping
	public List<Dispositivo> getAllDispositivi() {
		return dispositivoService.getAllDispositivi();
	}

	@GetMapping("/{id}")
	public Dispositivo getDispositivoById(@PathVariable Long id) {
		return dispositivoService.getDispositivoById(id);
	}

	@PostMapping
	public Dispositivo createDispositivo(@RequestBody Dispositivo dispositivo) {
		return dispositivoService.createDispositivo(dispositivo);
	}

	@PutMapping("/{id}")
	public Dispositivo updateDispositivo(@PathVariable Long id, @RequestBody Dispositivo dispositivo) {
		return dispositivoService.updateDispositivo(id, dispositivo);
	}

	@DeleteMapping("/{id}")
	public void deleteDispositivo(@PathVariable Long id) {
		dispositivoService.deleteDispositivo(id);
	}

	@GetMapping("/stato/{stato}")
	public List<Dispositivo> getDispositiviByStato(@PathVariable String stato) {
		return dispositivoService.getDispositiviByStato(stato);
	}

	@GetMapping("/tipologia/{tipo}")
	public List<Dispositivo> getDispositiviByTipologia(@PathVariable EType tipo) {
		return dispositivoService.getDispositiviByTipo(tipo);
	}
}
