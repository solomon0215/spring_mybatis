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
		Question q1 = new Question( "당신의 역할은 무엇입니까?" , Arrays.asList("서비","프론트","풀스택"));
		Question q2 = new Question("자주 사용하는 개발 툴",Arrays.asList("Ecliops","Intellij", "Sublime"));
		Question q3 = new Question("하고 싶은 말을 적어주세요");
		return Arrays.asList(q1,q2,q3);
	}
}
