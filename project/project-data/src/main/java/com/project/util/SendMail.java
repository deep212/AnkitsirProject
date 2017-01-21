package com.project.util;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {

	public static String mailSend(String email, String name) {
		try {
			Message message = new MimeMessage(SendMailProperty.mailProperty());

			message.setFrom(new InternetAddress(IConstant.FROM_EMAIL_ID));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
			message.setSubject("Regards:registration confirmation");
			message.setSubject("click link for change password");
			String msg = "Dear " + name + ",<br>";
			msg += "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;You have been registered with Itportal below are confirmation link click on link and access jobpartal account:<br>";
			msg += " <br>";
			msg += "<b>User Name:</b>" + email;
			msg += " <br>";
			msg += "" + IConstant.REGISTRATION_URL;
			msg += "<b>User Name:</b>" + email;
			msg += " <br>";
			msg += "Regards,<br>";
			msg += "Job Portal";
			message.setContent(msg, "text/html");
			Transport.send(message);
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
		return null;

	}

	
}