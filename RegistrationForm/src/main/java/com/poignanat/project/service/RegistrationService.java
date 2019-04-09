package com.poignanat.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poignanat.project.dto.RegistrationDTO;
import com.poignanat.project.repository.RegistrationRepository;


@Service
public class RegistrationService {
	@Autowired
	private RegistrationRepository repository;

	public RegistrationService() {
		System.out.println("created:" + this.getClass().getSimpleName());
	}

	public void saving()
	{
		RegistrationDTO dto=new RegistrationDTO();
		System.out.println("saving data into database:");
		String mail=dto.setEmail(dto.getEmail());
		System.out.println("email is "+mail);
		
		String name=dto.setFirstname(dto.getFirstname());
		System.out.println("name is:"+name);
		
		String gender=dto.setGender(dto.getGender());
		System.out.println("gender is:"+gender);
		dto.setUploadfiles(dto.getUploadfiles());
		repository.save(dto);
	}
}
