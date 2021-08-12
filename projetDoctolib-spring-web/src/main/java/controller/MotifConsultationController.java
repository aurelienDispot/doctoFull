package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.MotifConsultation;
import repository.IMotifConsultationRepository;

public class MotifConsultationController {
	@Autowired
	private IMotifConsultationRepository motifConsultationRepo;

	@GetMapping("/rendezVous") // ETAPE 1
	public String list(Model model) {
		// ETAPE 2
		List<MotifConsultation> motifConsultations = this.motifConsultationRepo.findAll();

		// ETAPE 3
		model.addAttribute("mesMotifs", motifConsultations);

		// ETAPE 4
		return "motifConsultation/list";
	}

	@GetMapping("/motifConsultation/add")
	public String add() {
		// ETAPE 2 et 3 inutile
		// ETAPE 4
		return "motifConsultation/form";
	}

	@GetMapping("/motifConsultation/edit")
	public String edit(@RequestParam("id") Long idMotifConsultation, Model model) {
		// ETAPE 2
		MotifConsultation motifConsultation = motifConsultationRepo.findById(idMotifConsultation).get();

		// ETAPE 3
		model.addAttribute("mc", motifConsultation);

		// ETAPE 4
		return "motifConsultation/form";
	}
	
	@PostMapping("/motifConsultation/save")
	public String save(@RequestParam(required = false) Long id, @RequestParam(required = false, defaultValue = "0") int version, @RequestParam String nom, @RequestParam String description, @RequestParam int nbCreneaux) {
		MotifConsultation motifConsultation = new MotifConsultation(id, nom, description, nbCreneaux);
		motifConsultation.setVersion(version);
		
		motifConsultationRepo.save(motifConsultation);
		
		return "redirect:/motifConsultation";
	}

	@GetMapping("/motifConsultation/delete")
	public String delete(@RequestParam Long id) {
		motifConsultationRepo.deleteById(id);
		
		return "redirect:/motifConsultation";
	}
	
	@GetMapping("/motifConsultation/cancel")
	public String cancel() {
		return "forward:/motifConsultation";
	}
}
