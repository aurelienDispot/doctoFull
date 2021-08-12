package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.Lieux;
import repository.ILieuxRepository;


@Controller
public class LieuxController {
	
	@Autowired
	private ILieuxRepository lieuxRepo;

	@GetMapping("/lieux") // ETAPE 1
	public String list(Model model) {
		// ETAPE 2
		List<Lieux> lieux = this.lieuxRepo.findAll();

		// ETAPE 3
		model.addAttribute("mesLieux", lieux);

		// ETAPE 4
		return "lieux/listLieux";
	}

	@GetMapping("/lieux/add")
	public String add() {
		// ETAPE 2 et 3 inutile
		// ETAPE 4
		return "lieux/formLieux";
	}

	@GetMapping("/lieux/edit")
	public String edit(@RequestParam("id") Long idLieux, Model model) {
		// ETAPE 2
		Lieux lieux = lieuxRepo.findById(idLieux).get();

		// ETAPE 3
		model.addAttribute("lieux", lieux);

		// ETAPE 4
		return "lieux/formLieux";
	}
	
	@PostMapping("/lieux/save")
	public String save(@RequestParam(required = false) Long id, @RequestParam(required = false, defaultValue = "0") int version, @RequestParam Integer comportemental, @RequestParam Integer technique, @RequestParam String commentaires) {
		Evaluation evaluation = new Evaluation(id, comportemental, technique, commentaires);
		evaluation.setVersion(version);
		
		lieuxRepo.save(evaluation);
		
		return "redirect:/lieux";
	}

	@GetMapping("/lieux/delete")
	public String delete(@RequestParam Long id) {
		lieuxRepo.deleteById(id);
		
		return "redirect:/lieux";
	}
	
	@GetMapping("/lieux/cancel")
	public String cancel() {
		return "forward:/lieux";
	}
}

}
