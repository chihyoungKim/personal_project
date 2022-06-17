package controller.member;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Properties;
import java.util.Random;
import java.util.UUID;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mindrot.jbcrypt.BCrypt;

import com.google.gson.Gson;

import domain.Member;
import domain.Reply;
import service.MemberService;
import service.MemberServiceImpl;

@WebServlet("/member/sendTemporaryPw")
public class SendTemporaryPw extends HttpServlet{
	private MemberService memberService = MemberServiceImpl.getInstance(); 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//파라미터 처리
		String email = req.getParameter("email");
		String name = req.getParameter("name");
		
		Member member = memberService.findBy(email);
		
		String host = "http://localhost:8080" + req.getContextPath() + "/member/login";
		
		//임시비밀번호 생성
		UUID uuid = UUID.randomUUID();
		String password = uuid.toString().substring(0, 3);
		member.setPw(password);
		memberService.modify(member);
		
		String content = String.format("<table width='600' style='margin: 0 auto;'>\r\n" + 
				"        <tr>\r\n" + 
				"            <td align='center'><h1>이 이메일은 본인 확인을 위한 이메일 입니다.</h1></td>\r\n" + 
				"        </tr>\r\n" + 
				"        <tr>\r\n" + 
				"            <td align='center'><p style='color: #555555;'>회원님의 계정은 %s, 임시비밀번호는 %s입니다</p></td>\r\n" + 
				"        </tr>\r\n" + 
				"        <tr>\r\n" + 
				"            <td align='center'>\r\n" + 
				"                <a href='%s'><h3>로그인하러가기</h3></a>\r\n" + 
				"            </td>\r\n" + 
				"        </tr>\r\n" + 
				"    </table>", member.getId(), member.getPw(), host);
		
		//메일 발송
		
		
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		
		Session session = Session.getInstance(props, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("wdchkim@gmail.com", "yyusgvhilwgdlrvw");
			}
		});
		
		String receiver = email;
		String title = "[휴먼투어] 임시비밀번호입니다.";
		Message message = new MimeMessage(session);
		
		try {
			message.setFrom(new InternetAddress("wdchkim@gmail.com", "관리자", "utf-8"));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(receiver));
			message.setSubject(title);
			message.setContent(content, "text/html;charset=utf-8");
			
			Transport.send(message);
		}
		catch (AddressException e) {
			e.printStackTrace();
		}
		catch (MessagingException e) {
			e.printStackTrace();
		}
		catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		resp.setContentType("text/plain");
	}

}
