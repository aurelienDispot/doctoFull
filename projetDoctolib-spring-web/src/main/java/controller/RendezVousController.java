package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.RendezVous;
import model.Statut;
import repository.IRendezVousRepository;

@Controller
public class RendezVousController {
	@Autowired
	private IRendezVousRepository rendezVousRepo;

	@GetMapping("/rendezVous") // ETAPE 1
	public String list(Model model) {
		// ETAPE 2
		List<RendezVous> rendezVouss = this.rendezVousRepo.findAll();

		// ETAPE 3
		model.addAttribute("mesRendezVous", rendezVouss);

		// ETAPE 4
		return "rendezVous/list";
	}

	@GetMapping("/rendezVous/add")
	public String add() {
		// ETAPE 2 et 3 inutile
		// ETAPE 4
		return "rendezVous/form";
	}

	@GetMapping("/rendezVous/edit")
	public String edit(@RequestParam("id") Long idRendezVous, Model model) {
		// ETAPE 2
		RendezVous rendezVous = rendezVousRepo.findById(idRendezVous).get();

		// ETAPE 3
		model.addAttribute("rdv", rendezVous);

		// ETAPE 4
		return "rendezVous/form";
	}
	
	@GetMapping("/rendezVous/creneauxHoraires")
	public String creneauxHoraires(@RequestParam("id") Long idCreneauxHoraires, Model model) {
		
	}
	
	@PostMapping("/rendezVous/save")
	public String save(@RequestParam(required = false) Long id, @RequestParam(required = false, defaultValue = "0") int version, @RequestParam Statut statut, @RequestParam String nomPatient, @RequestParam String prenomPatient) {
		RendezVous rendezVous = new RendezVous(id, statut, nomPatient, prenomPatient);
		rendezVous.setVersion(version);
		
		rendezVousRepo.save(rendezVous);
		
		return "redirect:/rendezVous";
	}

	@GetMapping("/rendezVous/delete")
	public String delete(@RequestParam Long id) {
		rendezVousRepo.deleteById(id);
		
		return "redirect:/rendezVous";
	}
	
	@GetMapping("/rendezVous/cancel")
	public String cancel() {
		return "forward:/rendezVous";
	}
}
