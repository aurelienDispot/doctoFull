package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.Adresse;
import repository.IAdresseRepository;


@Controller
public class AdresseController {

	@Autowired
	private IAdresseRepository adresseRepo;

	@GetMapping("/adresse") // ETAPE 1
	public String list(Model model) {
		// ETAPE 2
		List<Adresse> adresse = this.adresseRepo.findAll();

		// ETAPE 3
		model.addAttribute("mesAdresses", adresse);

		// ETAPE 4
		return "adresse/listAdresse";
	}

	@GetMapping("/adresse/add")
	public String add() {
		// ETAPE 2 et 3 inutile
		// ETAPE 4
		return "adresse/formAdresse";
	}

	@GetMapping("/adresse/edit")
	public String edit(@RequestParam("id") Long idAdresse, Model model) {
		// ETAPE 2
		Adresse adresse = adresseRepo.findById(idAdresse).get();

		// ETAPE 3
		model.addAttribute("adr", adresse);

		// ETAPE 4
		return "adresse/formAdresse";
	}
	
	@PostMapping("/adresse/save")
	public String save(@RequestParam(required = false) Long id, @RequestParam(required = false, defaultValue = "0") int version, @RequestParam Integer comportemental, @RequestParam Integer technique, @RequestParam String commentaires) {
		Evaluation evaluation = new Evaluation(id, comportemental, technique, commentaires);
		evaluation.setVersion(version);
		
		adresseRepo.save(evaluation);
		
		return "redirect:/evaluation";
	}

	@GetMapping("/adresse/delete")
	public String delete(@RequestParam Long id) {
		adresseRepo.deleteById(id);
		
		return "redirect:/adresse";
	}
	
	@GetMapping("/adresse/cancel")
	public String cancel() {
		return "forward:/adresse";
	}
}
