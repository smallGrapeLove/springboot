package com.xuhuan.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot4TaskApplicationTests {

	@Autowired
	JavaMailSenderImpl javaMailSender;

	@Test
	public void contextLoads() {

	}

	/**
	 * 简单邮件
	 */
	@Test
	public void sendSimpleEmail(){
		SimpleMailMessage mailMessage=new SimpleMailMessage();
		mailMessage.setSubject("邮箱测试1");//主题
		mailMessage.setText("content");//正文
		mailMessage.setTo("momo_xh0817@163.com");//收件人
		mailMessage.setFrom("momo_xh0817@163.com");//发件人
		javaMailSender.send(mailMessage);

	}

	/**
	 * 带附件邮件
	 * @throws MessagingException
	 */
	@Test
	public void sendEmail() throws MessagingException {
		MimeMessage mimeMessage=javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper=new MimeMessageHelper(mimeMessage,true);

		mimeMessageHelper.setSubject("邮箱测试1");
		mimeMessageHelper.setText("content");
		mimeMessageHelper.setTo("momo_xh0817@163.com");
		mimeMessageHelper.setFrom("momo_xh0817@163.com");

		//上传附件
		mimeMessageHelper.addAttachment("邮件附件.txt",new File("C:\\Users\\admin\\Desktop\\邮件附件.txt"));
		mimeMessageHelper.addAttachment("邮件附件1.txt",new File("C:\\Users\\admin\\Desktop\\邮件附件1 .txt"));
		mimeMessageHelper.addAttachment("邮件附件2.txt",new File("C:\\Users\\admin\\Desktop\\邮件附件12.txt"));

		javaMailSender.send(mimeMessage);


	}

}
