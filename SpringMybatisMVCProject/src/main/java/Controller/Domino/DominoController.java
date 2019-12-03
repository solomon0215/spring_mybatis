package Controller.Domino;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Service.Domino.DominoService;

@Controller
public class DominoController {
	@Autowired
	private DominoService dominoService;
	@RequestMapping("/domino")
	public String domino(Model model) {
		dominoService.execute(model);
		return "Domino/dominoMain";
	}
	@RequestMapping("/bDomino")
	public String domino2(Model model,@RequestParam("a")  Long a) {
		dominoService.execute1(model, a);
		return "Domino/bDTO";
	}
	@RequestMapping("/cDomino")
	public String domino3(Model model,@RequestParam("a")  Long a,@RequestParam("c")  Long c) {
		dominoService.execute2(model, a,c);
		return "Domino/cDTO";
	}
}
