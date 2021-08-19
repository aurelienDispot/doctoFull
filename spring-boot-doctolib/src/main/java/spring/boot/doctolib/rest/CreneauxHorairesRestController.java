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

import spring.boot.doctolib.model.CreneauxHoraires;
import spring.boot.doctolib.model.Views;
import spring.boot.doctolib.repository.ICreneauxHorairesRepository;

@RestController
@RequestMapping("/CreneauxHoraires")
@CrossOrigin("*")
public class CreneauxHorairesRestController {

	@Autowired
	private ICreneauxHorairesRepository creneauxHorairesRepo;
	
	@GetMapping("")
	@JsonView(Views.ViewCreneauxHoraires.class)
	public List<CreneauxHoraires> findAll() {
		return creneauxHorairesRepo.findAll();
	}
	
	@GetMapping("/{id}")
	@JsonView(Views.ViewCreneauxHoraires.class)
	public CreneauxHoraires find(@PathVariable Long id) {

		Optional<CreneauxHoraires> optCreneauxHoraires = creneauxHorairesRepo.findById(id);
	
		if (optCreneauxHoraires.isPresent()) {
			return optCreneauxHoraires.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
	}
	
	@PostMapping("")
	public CreneauxHoraires create(@RequestBody CreneauxHoraires creneauxHoraires) {
		creneauxHoraires = creneauxHorairesRepo.save(creneauxHoraires);

		return creneauxHoraires;
	}
	
	@PutMapping("/{id}")
	public CreneauxHoraires update(@RequestBody CreneauxHoraires creneauxHoraires, @PathVariable Long id) {
		if (!creneauxHorairesRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}

		creneauxHoraires = creneauxHorairesRepo.save(creneauxHoraires);

		return creneauxHoraires;
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		if (!creneauxHorairesRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
		
		creneauxHorairesRepo.deleteById(id);
	}
}
