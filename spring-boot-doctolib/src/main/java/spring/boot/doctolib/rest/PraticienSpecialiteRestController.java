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

import spring.boot.doctolib.model.PraticienSpecialite;
import spring.boot.doctolib.model.Specialite;
import spring.boot.doctolib.repository.IPraticienSpecialiteRepository;
import spring.boot.doctolib.repository.ISpecialiteRepository;

@RestController
@RequestMapping("/praticienSpecialite")
@CrossOrigin
public class PraticienSpecialiteRestController {
	@Autowired
	private IPraticienSpecialiteRepository praticienspecialiteRepo;
	
	@GetMapping("")
	public List<PraticienSpecialite> findAll(){
		return praticienspecialiteRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public PraticienSpecialite findPraticienSpecialite(@PathVariable Long id) {
		Optional<PraticienSpecialite> optPraticienSpecialite = praticienspecialiteRepo.findPraticienSpecialiteId(id);

		if (optPraticienSpecialite.isPresent()) {
			return optPraticienSpecialite.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
	}
	
	@PostMapping("")
	public PraticienSpecialite create(@RequestBody PraticienSpecialite specialite) {
		specialite = praticienspecialiteRepo.save(specialite);
		return specialite;
	}
	
	@PutMapping("/{id}")
	public PraticienSpecialite update(@RequestBody PraticienSpecialite specialite, @PathVariable Long id) {
		
		if (!praticienspecialiteRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
		specialite = praticienspecialiteRepo.save(specialite);
		return specialite;
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		if (!praticienspecialiteRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
		praticienspecialiteRepo.deleteById(id);
	}

}
