package com.poignanat.project.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.poignanat.project.dto.RegistrationDTO;
import com.poignanat.project.service.RegistrationService;


@RestController
public class RegistrationController {

	@Autowired
	private RegistrationService service;

	public RegistrationController() {
		System.out.println("created:" + this.getClass().getSimpleName());
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/Registration", method = RequestMethod.POST)
	@PostConstruct
	public void saving() {
		RegistrationDTO dto = new RegistrationDTO();
		System.out.println("invoking a method inside controller");
		service.saving();
		System.out.println("data saved");
	}
}
