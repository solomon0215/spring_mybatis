package Serviec.Member;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

@Service
public class MemberLogoutService {
	public void logout(HttpSession session, HttpServletResponse response) {
		Cookie autoLoginCookie = new Cookie("AutoLogin", "");
		autoLoginCookie.setMaxAge(0); // cookies delete need befores the session invalidate
		session.invalidate();
	}
}
