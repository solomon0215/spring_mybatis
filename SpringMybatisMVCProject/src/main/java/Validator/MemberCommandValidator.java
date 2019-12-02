package Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import Command.MemberCommand;

public class MemberCommandValidator implements Validator{
	private static final String emailRegExp=
			"^[_A-Za-z0-9-](.[_A-Za-z0-9-]+)*@(?:\\w+\\.)+\\w+$";
	private Pattern pattern ;
	
	private static final String birthRegExp = "^\\d{4}-\\d{2}-\\d{2}$";
	private Pattern birthPattern ;
	
	public MemberCommandValidator() {
		pattern =  Pattern.compile(emailRegExp);
		birthPattern = Pattern.compile(birthRegExp);
	}
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		MemberCommand memCmd = (MemberCommand)target;
		if(memCmd.getUserEmail() == null || 
				memCmd.getUserEmail().trim().isEmpty()) {
			errors.rejectValue("userEmail", "required");
		}else{
			// false/ true
			Matcher matcher = pattern.matcher(memCmd.getUserEmail()); 
			if(!matcher.matches()) {
				errors.rejectValue("userEmail", "bad");
			}
		}
		if(memCmd.getUserBirth() == null || 
				memCmd.getUserBirth().trim().isEmpty()) {
			errors.rejectValue("userBirth", "required");
		}else {
			Matcher matcher = birthPattern.matcher(memCmd.getUserBirth()); 
			if(!matcher.matches()) {
				errors.rejectValue("userBirth", "bad1");
			}
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", 
				"required");
		ValidationUtils.rejectIfEmpty(errors, "userPw", "required");
		ValidationUtils.rejectIfEmpty(errors, "userId", "required");
		ValidationUtils.rejectIfEmpty(errors, "userAddr", "required");
		ValidationUtils.rejectIfEmpty(errors, "userPh1", "required");
		ValidationUtils.rejectIfEmpty(errors, "userPwCon", "required");
		if(!memCmd.getUserPw().isEmpty()){
			if(!memCmd.isPwEqualToPwCon()) {
				errors.rejectValue("userPwCon", "nomatch");
			}
		}
	}

}
