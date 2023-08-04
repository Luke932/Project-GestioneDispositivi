package luke932.gestioneDispositivi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import exception.UnauthorizedException;
import luke932.gestioneDispositivi.entities.Utente;
import luke932.gestioneDispositivi.payload.LoginSuccessfullPayload;
import luke932.gestioneDispositivi.payload.UserLoginPayload;
import luke932.gestioneDispositivi.payload.UserRequestPayload;
import luke932.gestioneDispositivi.security.JWTTools;
import luke932.gestioneDispositivi.service.UtenteService;

@RestController
@RequestMapping("/auth")
public class AuthController {
	@Autowired
	UtenteService usersService;

	@Autowired
	JWTTools jwtTools;

	@PostMapping("/register")
	@ResponseStatus(HttpStatus.CREATED)
	public Utente saveUser(@RequestBody UserRequestPayload body) {
		Utente created = usersService.createUtente(body);

		return created;
	}

	@PostMapping("/login")
	public LoginSuccessfullPayload login(@RequestBody UserLoginPayload body) {

		Utente user = usersService.findByEmail(body.getEmail());

		if (body.getPassword().equals(user.getPassword())) {

			String token = jwtTools.createToken(user);
			return new LoginSuccessfullPayload(token);

		} else {

			throw new UnauthorizedException("Credenziali non valide!");
		}
	}

}