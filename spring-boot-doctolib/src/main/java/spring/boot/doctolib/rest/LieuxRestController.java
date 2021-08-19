package spring.boot.doctolib.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
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


import spring.boot.doctolib.model.Lieux;
import spring.boot.doctolib.model.Views;
import spring.boot.doctolib.repository.ILieuxRepository;

@RestController
@RequestMapping("/Lieux")
@CrossOrigin("*")
public class LieuxRestController {

	@Autowired
	private ILieuxRepository lieuxRepo;
	
	@GetMapping("")
	@JsonView(Views.ViewLieux.class)
	@PreAuthorize("hasAnyRole('Praticien','Patient', 'Admin')")
	public List<Lieux> findAll() {
		return lieuxRepo.findAll();
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewLieux.class)
	public Lieux find(@PathVariable Long id) {

		Optional<Lieux> optLieux = lieuxRepo.findById(id);
	
		if (optLieux.isPresent()) {
			return optLieux.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
	}
	
	@PostMapping("")
	public Lieux create(@RequestBody Lieux lieux) {
		lieux = lieuxRepo.save(lieux);

		return lieux;
	}
	
	@PutMapping("/{id}")
	public Lieux update(@RequestBody Lieux lieux, @PathVariable Long id) {
		if (!lieuxRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}

		lieux = lieuxRepo.save(lieux);

		return lieux;
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		if (!lieuxRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
		
		lieuxRepo.deleteById(id);
	}
	
}
