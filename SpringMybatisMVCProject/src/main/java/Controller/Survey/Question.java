package Controller.Survey;

import java.util.List;

public class Question {
	private String title;
	private List<String> options;
	public String getTitle() {
		return title;
	}
	public List<String> getOptions() {
		return options;
	}
	public Question(String title, List<String> options) {
		super();
		this.title = title;
		this.options = options;
	}
	public Question(String title) {
		super();
		this.title = title;
	}
	public boolean isChoise() {
		return options != null && !options.isEmpty();
	}
}
