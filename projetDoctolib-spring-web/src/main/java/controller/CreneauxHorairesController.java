package controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.CreneauxHoraires;
import model.Lieux;
import model.Praticien;
import model.RendezVous;
import repository.ICreneauxHorairesRepository;


@Controller
public class CreneauxHorairesController {
	
	@Autowired
	private ICreneauxHorairesRepository creneauxHorairesRepo;

	@GetMapping("/creneauxHoraires") // ETAPE 1
	public String list(Model model) {
		// ETAPE 2
		List<CreneauxHoraires> creneauxHoraires = this.creneauxHorairesRepo.findAll();

		// ETAPE 3
		model.addAttribute("mesCreneauxHoraires", creneauxHoraires);

		// ETAPE 4
		return "creneauxHoraires/listCreneauxHoraires";
	}

	@GetMapping("/creneauxHoraires/add")
	public String add() {
		// ETAPE 2 et 3 inutile
		// ETAPE 4
		return "creneauxHoraires/formCreneauxHoraires";
	}

	@GetMapping("/creneauxHoraires/edit")
	public String edit(@RequestParam("id") Long idCreneauxHoraires, Model model) {
		// ETAPE 2
		CreneauxHoraires creneauxHoraires = creneauxHorairesRepo.findById(idCreneauxHoraires).get();

		// ETAPE 3
		model.addAttribute("crenHor", creneauxHoraires);

		// ETAPE 4
		return "creneauxHoraires/formCreneauxHoraires";
	}
	
	@PostMapping("/creneauxHoraires/save")
	public String save(@RequestParam(required = false) Long id, @RequestParam(required = false, defaultValue = "0") int version, @RequestParam Date dtDebut, @RequestParam Lieux lieux, @RequestParam RendezVous rendezVous, @RequestParam Praticien praticien) {
		CreneauxHoraires creneauxHoraires = new CreneauxHoraires(id, dtDebut, lieux, praticien);
		creneauxHoraires.setVersion(version);
		
		creneauxHorairesRepo.save(creneauxHoraires);
	
		return "redirect:/evaluation";
	}

	@GetMapping("/creneauxHoraires/delete")
	public String delete(@RequestParam Long id) {
		creneauxHorairesRepo.deleteById(id);
		
		return "redirect:/creneauxHoraires";
	}
	
	@GetMapping("/creneauxHoraires/cancel")
	public String cancel() {
		return "forward:/creneauxHoraires";
	}
}
