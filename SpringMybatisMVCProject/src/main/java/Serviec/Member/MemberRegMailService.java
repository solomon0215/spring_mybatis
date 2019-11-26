package Serviec.Member;

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
		String content = "<html><body>"
						+ "�ȳ��ϼ���'"+name+"'�� ������ ȯ���մϴ�.<br>"
						+ "�Ʒ� ��ũ�� �����ž߸� ������ �Ϸ� �˴ϴ�.<br>"
						+ "<a href='http://192.168.3.131:8080/SpringMybatisMVCProject/memberMail?num="+num
						+"&name="+name+"&reciver="+reciver+"'>"
						+ "<strong><b>������ �Ϸ��Ͻ÷��� ���⸦ �����ּ���.</b></strong>"
						+ "</a></body></html>";
		String subject = "����ȯ�� �λ�";
		try {
			msg.setHeader("content-type", "text/html; charset=UTF-8");
			msg.setContent(content, "text/html; charset=UTF-8");
			msg.setSubject(subject);
			msg.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(reciver));
			mailSender.send(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
