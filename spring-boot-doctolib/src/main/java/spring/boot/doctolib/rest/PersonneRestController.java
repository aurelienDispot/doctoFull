package spring.boot.doctolib.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import spring.boot.doctolib.model.Personne;
import spring.boot.doctolib.model.Views;
import spring.boot.doctolib.repository.IPersonneRepository;

@RestController
@RequestMapping("/personne")
@CrossOrigin("*")
public class PersonneRestController {

	@Autowired
	private IPersonneRepository personneRepo;

	@GetMapping("")
	@JsonView(Views.ViewPersonne.class)
	public List<Personne> findAll() {
		return personneRepo.findAll();
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewPersonne.class)
	public Personne find(@PathVariable Long id) {

		Optional<Personne> optPersonne = personneRepo.findById(id);

		if (optPersonne.isPresent()) {
			return (Personne) optPersonne.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
	}

	@PostMapping("")
	public Personne create(@RequestBody Personne personne) {
		personne = personneRepo.save(personne);

		return personne;
	}

	@PutMapping("/{id}")
	public Personne update(@RequestBody Personne personne, @PathVariable Long id) {
		if (!personneRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}

		personne = personneRepo.save(personne);

		return personne;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		if (!personneRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
		
		personneRepo.deleteById(id);
	}
}