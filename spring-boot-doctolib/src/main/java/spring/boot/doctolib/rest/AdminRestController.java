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

import spring.boot.doctolib.model.Admin;
import spring.boot.doctolib.model.Personne;
import spring.boot.doctolib.model.Views;
import spring.boot.doctolib.repository.IPersonneRepository;

@RestController
@RequestMapping("/admin")
@CrossOrigin("*")
public class AdminRestController {

	@Autowired
	private IPersonneRepository adminRepo;

	@GetMapping("")
	@JsonView(Views.ViewAdmin.class)
	public List<Admin> findAll() {
		return adminRepo.findAllAdmin();
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewAdmin.class)
	public Admin find(@PathVariable Long id) {

		Optional<Personne> optAdmin = adminRepo.findById(id);

		if (optAdmin.isPresent()) {
			return (Admin) optAdmin.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
	}

	@PostMapping("")
	public Admin create(@RequestBody Admin admin) {
		admin = adminRepo.save(admin);

		return admin;
	}

	@PutMapping("/{id}")
	public Admin update(@RequestBody Admin admin, @PathVariable Long id) {
		if (!adminRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}

		admin = adminRepo.save(admin);

		return admin;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		if (!adminRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
		
		adminRepo.deleteById(id);
	}
}
