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

import spring.boot.doctolib.model.RendezVous;
import spring.boot.doctolib.model.Views;
import spring.boot.doctolib.repository.IRendezVousRepository;


@RestController
@RequestMapping("/rendezvous")
@CrossOrigin("*")
public class RendezVousRestController {


	@Autowired
	private IRendezVousRepository rendezVousRepo;

	@GetMapping("")
	@JsonView(Views.ViewRendezVous.class)
	public List<RendezVous> findAll() {
		return rendezVousRepo.findAll();
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewRendezVous.class)
	public RendezVous find(@PathVariable Long id) {

		Optional<RendezVous> optRendezVous = rendezVousRepo.findById(id);

		if (optRendezVous.isPresent()) {
			return optRendezVous.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
	}

	@PostMapping("")
	@JsonView(Views.ViewRendezVous.class)
	public RendezVous create( @RequestBody RendezVous rendezVous) {

		rendezVous = rendezVousRepo.save(rendezVous);

		return rendezVous;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewRendezVous.class)
	public RendezVous update(@RequestBody RendezVous rendezVous, @PathVariable Long id) {
		if (!rendezVousRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}

		rendezVous = rendezVousRepo.save(rendezVous);

		return rendezVous;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		if (!rendezVousRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}

		rendezVousRepo.deleteById(id);
	}
}
