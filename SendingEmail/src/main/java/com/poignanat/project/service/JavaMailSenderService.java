package com.poignanat.project.service;

import java.nio.charset.StandardCharsets;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import com.poignanat.project.dto.MailRequestDTO;
import com.poignanat.project.dto.MailResponseDTO;

import freemarker.template.Configuration;
import freemarker.template.Template;

@Service
public class JavaMailSenderService {
	public JavaMailSenderService() {

		System.out.println("cretaed:" + this.getClass().getSimpleName());
	}

	@Autowired
	private JavaMailSender sender;

	@Autowired
	private Configuration config;

	public MailResponseDTO sendMail(MailRequestDTO req, Map<String, Object> model) {
		System.out.println("invoking this sending mail in service");
		MimeMessage message = sender.createMimeMessage();
		System.out.println("this is :" + message);
		MailResponseDTO res = new MailResponseDTO();
		try {
			System.out.println("mail sending 1");
			// set for media type
			MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
					StandardCharsets.UTF_8.name());
			// adding attachmeet
			System.out.println("mail sending helper "+ helper);
			helper.addAttachment("logo.png", new ClassPathResource("logo.png"));
			System.out.println("mail sending 2");
			Template t = config.getTemplate("email-template.ftl");
			System.out.println("mail sending t "+ t);
			String html = FreeMarkerTemplateUtils.processTemplateIntoString(t, model);
			// adding mail related info ,to ,sub,txt
			System.out.println("mail sending html "+html);
			helper.setTo(req.getTo());
			System.out.println("mail sending setTo ");
			helper.setSubject(req.getSubject());
			System.out.println("mail sending subject");
			helper.setText(html, true);
			System.out.println("mail sending text");
			helper.setFrom(req.getFrom());
			System.out.println("mail sending from");
			res.setMessage("Mail send to :" + req.getTo());
			System.out.println("mail sending message");
			
			sender.send(message);
			System.out.println("mail sending send");
			res.setStatus(Boolean.TRUE);
			System.out.println("mail sending status");
			
			System.out.println("mail sending end");
		} catch (Exception e) {
			e.printStackTrace();
			res.setMessage("mail sending failure:" + req.getTo());
		}
		return res;
	}

}
