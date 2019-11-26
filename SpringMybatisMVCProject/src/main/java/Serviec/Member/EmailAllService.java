package Serviec.Member;

import java.util.List;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import Model.DTO.MemberDTO;
import Repository.Member.MemberRepository;

@Service
public class EmailAllService {
	@Autowired
	private JavaMailSender mailSender;
	@Autowired
	private MemberRepository memberRepository;
	
	public void sendAll() {
		List<String> recivers = memberRepository.selectMemberAll();
		
		String subject = "안녕하세요";
		String content = "이러다 제가 죽으면 어떡합니까?";
		MimeMessage msg = mailSender.createMimeMessage();
		for(String reciver : recivers ) {
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
}
