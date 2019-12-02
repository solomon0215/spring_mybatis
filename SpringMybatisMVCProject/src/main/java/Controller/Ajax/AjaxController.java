package Controller.Ajax;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AjaxController {
	@RequestMapping("/ajaxTest")
	public String ajaxTest() {
		return "Ajax/AjaxTest";
	}
	@RequestMapping("/AjaxForm")
	public String ajaxForm() {
		
		return "Ajax/AjaxTest1";
	}
	@RequestMapping(value="/AjaxTest1",  method = RequestMethod.POST)
	public String ajaxTest(@ModelAttribute("n") String n) {
		
		return "Ajax/AjaxTest1Pro";
	}
	@RequestMapping("/AjaxTest2")
	public String ajaxTest2(@ModelAttribute("n") String n) {
		
		return "Ajax/AjaxTest2Pro";
	}
	
}
