package controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.Personne;
import model.Praticien;
import model.RendezVous;
import repository.IPersonneRepository;
import repository.IRendezVousRepository;

@Controller
public class PatientController {
	
	@Autowired
	private IPersonneRepository patientRepo;
	
	@Autowired
	private IRendezVousRepository rdvRepo;
	
	@GetMapping("/patient") // ETAPE 1
	public String list(Model model) {
		// ETAPE 2
		List<Praticien> praticiens = this.patientRepo.findAllPraticien();

		// ETAPE 3
		model.addAttribute("mesPraticiens", praticiens);

		// ETAPE 4
		return "patient/list";
	}
	
	@GetMapping("/patient/choosePraticienByNom")
	public String choosePraticienByNom(Model model, @RequestParam String nom) {
		List<Praticien> praticiens = this.patientRepo.findAllPraticienByNom(nom);
		
		model.addAttribute("mesPraticiens", praticiens);
		
		return "patient/list";
	}
	
	@GetMapping("/patient/choosePraticienBySpecialite")
	public String choosePraticienBySpecialite(Model model, @RequestParam String nom) {
		List<Praticien> praticiens = this.patientRepo.findAllPraticienBySpecialite(nom);
		
		model.addAttribute("mesPraticiens", praticiens);
		
		return "patient/list";
	}
	
	@GetMapping("/patient/choosePraticienByLieu")
	public String choosePraticienByLieu(Model model, @RequestParam String nom) {
		List<Praticien> praticiens = this.patientRepo.findAllPraticienByLieux(nom);
		
		model.addAttribute("mesPraticiens", praticiens);
		
		return "patient/list";
	}
	
	@GetMapping("/patient/chooseHim")
	public String chooseHim(@RequestParam Long id, Model model) {
		Optional<Personne> praticien = patientRepo.findById(id);
		
		model.addAttribute("monPraticien", praticien);
		
		return "redirect:/creneauxHoraires/findByPraticien";
	}
	
	@GetMapping("/patient/rdv")
	public String rdv(Model model, @RequestParam Long id) {
		List<RendezVous> rdvs = rdvRepo.findAllRdVByidPatient(id);
		
		model.addAttribute("mesRdv",rdvs);
		
		return "rendezVous/list";
	}
	
	@GetMapping("/patient/cancel")
	public String cancel() {
		return "forward:/patient";
	}	
}
