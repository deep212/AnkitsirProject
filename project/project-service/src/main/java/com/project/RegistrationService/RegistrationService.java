package com.project.RegistrationService;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.project.model.Attachment;
import com.project.model.Registration;


public interface RegistrationService {
	
	public boolean save(Registration userProfile, CommonsMultipartFile[] file);
    public Registration getEmailId(String emailId);
    public Attachment getProfilePic(Integer registrationId);
}
