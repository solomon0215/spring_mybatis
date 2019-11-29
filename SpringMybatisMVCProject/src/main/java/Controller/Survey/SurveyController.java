package Controller.Survey;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Command.Survey.AnsweredData;

@Controller
@RequestMapping("/survey")
public class SurveyController {
	@RequestMapping(method = RequestMethod.GET)
	public String form(Model model) {
		List<Question> questions = createQuestions();
		model.addAttribute("questions", questions);
		return "survey/surveyForm";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String submit(@ModelAttribute("ansData") AnsweredData data) {
		return "survey/submitted";
	}
	private List<Question> createQuestions(){
		Question q1 = new Question( "����� ������ �����Դϱ�?" , Arrays.asList("����","����Ʈ","Ǯ����"));
		Question q2 = new Question("���� ����ϴ� ���� ��",Arrays.asList("Ecliops","Intellij", "Sublime"));
		Question q3 = new Question("�ϰ� ���� ���� �����ּ���");
		return Arrays.asList(q1,q2,q3);
	}
}
