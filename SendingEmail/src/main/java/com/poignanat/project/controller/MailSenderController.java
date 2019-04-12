package com.poignanat.project.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.poignanat.project.dto.MailRequestDTO;
import com.poignanat.project.dto.MailResponseDTO;
import com.poignanat.project.service.JavaMailSenderService;

@RestController
public class MailSenderController {
	public MailSenderController() {
		System.out.println("cretaed:" + this.getClass().getSimpleName());
	}

	@Autowired
	private JavaMailSenderService service;

	@PostMapping("/sendingEmail")
	public MailResponseDTO sendMail(@RequestBody MailRequestDTO req) {
		System.out.println("coming inside controller");
		Map<String, Object> model = new HashMap();
		model.put("Name", req.getName());
		model.put("loaction", "Banglore");
		System.out.println("coming inside controller");
		return service.sendMail(req, model);

	}

}
