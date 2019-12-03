package Service.Domino;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import Model.DTO.ADTO;
import Model.DTO.BDTO;
import Model.DTO.CDTO;
import Repository.Domino.DominoRepository;

@Service
public class DominoService {
	@Autowired
	private DominoRepository dominoRepository;
	public void execute(Model model) {
		List<ADTO> list = dominoRepository.selectA();
		model.addAttribute("aDTOs",list);
	}
	public void execute1(Model model,Long a) {
		System.out.println(a);
		List<BDTO> list = dominoRepository.selectB(a);
		model.addAttribute("bDTOs",list);
	}
	public void execute2(Model model, Long a,Long c) {
		System.out.println(a);
		System.out.println(c);
		BDTO bdto = new BDTO();
		bdto.setA(a);
		bdto.setC(c);
		List<CDTO> list = dominoRepository.selectC(bdto);
		model.addAttribute("cDTOs",list);
	}
}
