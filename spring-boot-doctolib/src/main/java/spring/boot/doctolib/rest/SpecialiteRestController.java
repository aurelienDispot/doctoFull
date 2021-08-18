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

import spring.boot.doctolib.model.Specialite;
import spring.boot.doctolib.repository.ISpecialiteRepository;

@RestController
@RequestMapping("/specialite")
@CrossOrigin
public class SpecialiteRestController {
	
	@Autowired
	private ISpecialiteRepository specialiteRepo;
	
	@GetMapping("")
	public List<Specialite> findAll(){
		return specialiteRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public Specialite findSpecialite(@PathVariable Long id) {
		Optional<Specialite> optSpecialite = specialiteRepo.findSpecialiteId(id);

		if (optSpecialite.isPresent()) {
			return optSpecialite.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
	}
	
	@PostMapping("")
	public Specialite create(@RequestBody Specialite specialite) {
		specialite = specialiteRepo.save(specialite);
		return specialite;
	}
	
	@PutMapping("/{id}")
	public Specialite update(@RequestBody Specialite specialite, @PathVariable Long id) {
		
		if (!specialiteRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
		specialite = specialiteRepo.save(specialite);
		return specialite;
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		if (!specialiteRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
		specialiteRepo.deleteById(id);
	}

	

}
