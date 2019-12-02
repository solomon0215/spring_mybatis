package Service.Member;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MemberRegMailService {
	@Autowired
	private JavaMailSender mailSender;
	
	public void sendMail(String reciver, String name) {
		MimeMessage msg = mailSender.createMimeMessage();
		SimpleDateFormat dateForm = new SimpleDateFormat("yyyyMMddHHmmss");
		String num = dateForm.format(new Date());
		String content = 
				  "<html><body>"
				+ "안녕하세요 '" + name +"'님 가입을 환영합니다.<br />"
				+ " 아래 링크를 누르셔야만 가입이 완료됩니다.<br />"
				+ "<a href='http://192.168.3.110:8080/"
				+ "SpringMybatisMVCProject/memberMail?num="+num
				+ "&name="+name+"&reciver="+reciver+"'>"
				+ "<strong><b>가입을 완료하시려면 여기를 눌러주세요. </b></strong>"
				+ "</a></body></html>";
		String subject = "가입환영인사";
		try {
			msg.setHeader("content-type", "text/html; charset=UTF-8");
			msg.setContent(content,"text/html; charset=UTF-8");
			msg.setSubject(subject);
			msg.setRecipient(MimeMessage.RecipientType.TO , 
					new InternetAddress(reciver));
			mailSender.send(msg);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}



