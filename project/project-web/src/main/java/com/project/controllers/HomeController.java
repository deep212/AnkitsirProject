package com.project.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.project.RegistrationService.RegistrationService;
import com.project.model.Attachment;
import com.project.model.Registration;
import com.project.util.IConstant;
import com.project.util.ImageFormat;
import com.project.util.SendMail;
import com.project.util.SendMail1;

@Controller
public class HomeController {
	@Autowired
	private RegistrationService service12;

	private Logger logger = Logger.getLogger(HomeController.class);

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String startIndex(@RequestParam(required = false) String message,
			Registration registration, ModelMap model,
			HttpServletRequest request) {
		logger.info("comes inside method");
		HttpSession session = request.getSession();
		session.invalidate();
		logger.info("comes inside method22");
		model.addAttribute("message", message);
		logger.info("comes inside method333");
		logger.error("hi my name is khan");
		return "home";
	}

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String registration(
			@ModelAttribute("registration") Registration registration,
			ModelMap model) {
		model.addAttribute("registration", new Registration());
		return "registration";
	}

	@RequestMapping(value = "/save", method = { RequestMethod.GET,
			RequestMethod.POST })
	public String save(
			@ModelAttribute("registration") Registration registration,
			@RequestParam(required = false) String message, ModelMap model,
			HttpServletRequest request,
			@RequestParam("filename") CommonsMultipartFile[] file) {
		String email = registration.getEmail();
		String name = registration.getName();
		service12.save(registration, file);

		SendMail.mailSend(email, name);
		model.addAttribute("message", IConstant.REGISTRATION_SUCCESS_MESSAGE);
		return "home";
	}

	@RequestMapping(value = "/login", method = { RequestMethod.GET,
			RequestMethod.POST })
	public String geData(
			@ModelAttribute("registration") Registration registration,
			ModelMap model, HttpServletRequest request) {
		HttpSession session = request.getSession();

		session.setAttribute("registration", registration);
		model.addAttribute("registration", new Registration());
		return "userlogin";
	}

	@RequestMapping(value = "/matchEmail", method = { RequestMethod.GET,
			RequestMethod.POST })
	public String MatchEmail(
			@ModelAttribute("registration") Registration registration,
			String RegistData, ModelMap model) throws IOException 
	{
		String email = registration.getEmail();
		Registration registration2 = service12.getEmailId(email);
		/*
		if (registration2 != null){*/
			
			Attachment attachment = service12.getProfilePic(registration2.getRegistrationId());
			/*if (attachment != null && attachment.getAttachmentType().equals("profilepic")) {*/
			    String path = ImageFormat.readImage(attachment.getPath());
			model.addAttribute("attachment", path);
			model.addAttribute("RegistData", registration2);
			return "userhome";
			}
		/*	return "userhome";
		} 
			else 
			{
		
		return "userlogin";*/
		
	@RequestMapping(value = "/UpdateProfile", method = { RequestMethod.GET,
			RequestMethod.POST })
	public String UpdateProfile(
			@ModelAttribute("registration") Registration registration,
			@RequestParam(required = false) String RegistData, ModelMap model) {
		String email = registration.getEmail();
		Registration registration2 = service12.getEmailId(email);
		model.addAttribute("registration", registration2);
		return "registration";
	}

	@RequestMapping(value = "/ForgetPassword", method = { RequestMethod.GET,
			RequestMethod.POST })
	public String ForgetPasssword(
			@ModelAttribute("registration") Registration registration,
			@RequestParam(required = false) String message, ModelMap model) {

		model.addAttribute("registration", new Registration());
		return "forget12";

	}

	@RequestMapping(value = "/ResetPassword", method = { RequestMethod.GET,
			RequestMethod.POST })
	public String ResetPassword(
			@ModelAttribute("registration") Registration registration,
			@RequestParam(required = false) String message, ModelMap model) {
		String email = registration.getEmail();
		SendMail1.mailSend(email);
		model.addAttribute("message",
				"please open gmail and Reset your password");
		return "redirect:index";

	}

	@RequestMapping(value = "/UpdatePassword", method = { RequestMethod.GET,
			RequestMethod.POST })
	public String AfterPaawordset(
			@ModelAttribute("registration") Registration registration,
			@RequestParam(required = false) String message, ModelMap model) {
		String email = registration.getEmail();
		model.addAttribute("message", "Choose_New_Paaword");
		return "changepassword";
	}

	@RequestMapping(value = "/SavePassword", method = { RequestMethod.GET,
			RequestMethod.POST })
	public String Sucessfully(
			@ModelAttribute("registration") Registration registration,
			@RequestParam(required = false) String message,
			@RequestParam(required = false) String email, ModelMap model,
			@RequestParam(required = false) String password,
			@RequestParam CommonsMultipartFile[] file) {
		registration.getEmail();
		registration = service12.getEmailId(email);
		// String password= registration.getPassword();
		registration.setPassword(password);
		registration.setPassword(registration.getPassword());
		service12.save(registration, file);
		model.addAttribute("message", "your password sucessfully changed");
		return "redirect:index";
	}
}