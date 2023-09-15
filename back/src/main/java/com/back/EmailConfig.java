package com.back;

import java.util.Collections;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Configuration
public class EmailConfig {

	   @Value("${spring.mail.host}")
	    private String host;

	    @Value("${spring.mail.port}")
	    private int port;

	    @Value("${spring.mail.username}")
	    private String username;

	    @Value("${spring.mail.password}")
	    private String password;
	

	 @Bean
	   public TemplateEngine emailTemplateEngine() {
	        final SpringTemplateEngine templateEngine = new SpringTemplateEngine();
	        templateEngine.addTemplateResolver(emailTemplateResolver());
	        return templateEngine;
	    }

	   private ITemplateResolver emailTemplateResolver() {
	        final ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
	        templateResolver.setOrder(1);
	        templateResolver.setPrefix("/templates/"); // Thymeleaf 템플릿 경로
	        templateResolver.setSuffix(".html");
	        templateResolver.setTemplateMode(TemplateMode.HTML);
	        templateResolver.setCharacterEncoding("UTF-8");
	        templateResolver.setCacheable(false); // 개발 중에는 캐시 사용 안 함
	        return templateResolver;
	    }    
	    
	    
	    
    @Bean
    public JavaMailSender javaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(host);
        mailSender.setPort(port); // SMTP 포트 번호
        mailSender.setUsername(username); // 이메일 계정
        mailSender.setPassword(password); // 이메일 비밀번호
        
        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.smtp.starttls.enable", "true"); // STARTTLS 활성화
        props.put("mail.smtp.auth", "true"); // SMTP 인증 활성화

        return mailSender;
    }
}
