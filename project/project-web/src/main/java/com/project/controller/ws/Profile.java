package com.project.controller.ws;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.RegistrationService.RegistrationService;
import com.project.model.Registration;

@Controller
public class Profile 
{
	@Autowired
	private RegistrationService service12;
	
	@RequestMapping(value = "/profileDeatils", method = RequestMethod.POST)
	public @ResponseBody Registration getSubject(
			@RequestBody Registration registration, HttpServletResponse response) {
		Map<Object, Object> map = new HashMap<Object, Object>();
		String email = registration.getEmail();
		Registration registration2 = service12.getEmailId(email);
		if (registration2 != null) {
			map.put("sucess", registration2);
			
		} else {
			map.put("nodata","No Data");
			
		}
		return registration2;
	}
	
}
