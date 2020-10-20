package com.project.recelmarket.user.email;

import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

@Service("mss")
public class MailSendService {
	 @Autowired
	    private JavaMailSenderImpl mailSender;

	    //인증키 생성
	    private String getKey(int size) {
	        return getAuthCode(size);
	    }

	    //인증코드 난수 발생
	    private String getAuthCode(int size) {
	        Random random = new Random();
	        StringBuffer buffer = new StringBuffer();
	        int num = 0;

	        while(buffer.length() < size) {
	            num = random.nextInt(10);
	            buffer.append(num);
	        }

	        return buffer.toString();
	    }

	    //인증메일 보내기
	    public String sendAuthMail(String email) {
	        //6자리 난수 인증번호 생성
	        String authKey = getKey(6);
	        
        	MimeMessage mail = mailSender.createMimeMessage();
            String htmlStr = (new StringBuffer().append("<h1>[이메일 인증]</h1>").append("<p>아래 버튼을 클릭하시면 이메일 인증이 완료됩니다.</p>")
					.append("<form action='http://localhost:8089/user/signUpConfirm' method='post'>")
					.append("<input type='hidden' name='email' value='").append(email).append("'>")
					.append("<input type='hidden' name='authKey' value='").append(authKey).append("'>")
					.append("<input type='submit' value='이메일 인증 확인' style='width: 200px; height: 50px; border: 0; border-radius: 10px; background: #08a600; margin-top: 30px;'>").toString());
	        //인증메일 보내기
	        try {
	            mail.setSubject("회원가입 이메일 인증");
				mail.setText(htmlStr, "utf-8", "html");
				mail.addRecipient(RecipientType.TO, new InternetAddress(email));
				mailSender.send(mail);

	        } catch (MessagingException e) {
	            e.printStackTrace();
	        }
	          return authKey;
	    }
}
