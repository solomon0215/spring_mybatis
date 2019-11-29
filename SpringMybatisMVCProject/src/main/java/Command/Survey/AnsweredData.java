package Command.Survey;

import java.util.List;

import Controller.Survey.Respondent;

public class AnsweredData {
	private List<String> reponses;
	private Respondent res;
	public List<String> getReponses() {
		return reponses;
	}
	public void setReponses(List<String> reponses) {
		this.reponses = reponses;
	}
	public Respondent getRes() {
		return res;
	}
	public void setRes(Respondent res) {
		this.res = res;
	}
	
}
