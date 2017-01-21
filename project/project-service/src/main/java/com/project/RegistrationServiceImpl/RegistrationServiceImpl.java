package com.project.RegistrationServiceImpl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.project.RegistrationService.RegistrationService;
import com.project.model.Attachment;
import com.project.model.Registration;
import com.project.repository.AttachmentRepository;
import com.project.repository.RegistrationRepository;
import com.project.util.IConstant;
@Service
public class RegistrationServiceImpl implements RegistrationService {

	private static final String newFile = null;
	@Autowired
	RegistrationRepository repository12;
	
	@Autowired
	AttachmentRepository attachement;

	public Registration getEmailId(String emailId) {
		
		return repository12.findByUserNameAndPass(emailId);
	}
	@SuppressWarnings("resource")
	@Transactional
	public boolean save(Registration userProfile, CommonsMultipartFile[] file) {
		
		
	    String attchmentName = null;
		OutputStream outputStream = null;
		InputStream inputStream = null;
		if (userProfile != null) {
		    if (file != null && file.length > 0) {
			for (CommonsMultipartFile multipartFile : file) {
			    attchmentName = multipartFile.getOriginalFilename();
			    try {
				inputStream = multipartFile.getInputStream();
				Registration currentUserProfile = repository12.save(userProfile);
				File newFile = new File(IConstant.FILE_PATH);
				File filePath = new File(newFile + File.separator + currentUserProfile.getRegistrationId() + "_"
						+ attchmentName);
				if (!newFile.exists()) {
				    newFile.mkdir();
				    filePath.createNewFile();
				}
				outputStream = new FileOutputStream(filePath);
				int read = 0;
				int length = (int) attchmentName.length();
				byte[] bytes = new byte[length];
				while ((read = inputStream.read(bytes)) != -1) {
				    outputStream.write(bytes, 0, read);
				}//
				String profilePic = FilenameUtils.getExtension(multipartFile.getOriginalFilename());
				if (profilePic.equals("jpg") || profilePic.equals("png") || profilePic.equals("doc")
						|| profilePic.equals("jpeg")) {
				    String attchmentType = "profilePic";
				    Attachment attchment = new Attachment();
				    Attachment oldAttchment = new Attachment();
				    oldAttchment = attachement.getProfilePicAttachment(
				    				currentUserProfile.getRegistrationId(), attchmentType);
				    
				    
				   
				    if (oldAttchment != null) {
					attchment = oldAttchment;
				    }
				    attchment.setAttachmentType(attchmentType);
				    attchment.setAttachmentName(attchmentName);
				    attchment.setPath(newFile + File.separator + currentUserProfile.getRegistrationId() + "_"
						    + attchmentName);
				    attchment.setRegistrationId(currentUserProfile.getRegistrationId());
				    attachement.save(attchment);
				} else {
				    if (profilePic.equals("txt") || profilePic.equals("doc") || profilePic.equals("sql")) {
					String attchmentType = "profilePic";
					Attachment attchment = new Attachment();
					Attachment oldAttchment = new Attachment();
					oldAttchment = attachement.getProfilePicAttachment(
									currentUserProfile.getRegistrationId(), attchmentType);
					if (oldAttchment != null) {
					    attchment = oldAttchment;
					}
					attchment.setAttachmentType(attchmentType);
					attchment.setAttachmentName(attchmentName);
					attchment.setPath(newFile + File.separator + currentUserProfile.getRegistrationId() + "_"
							+ attchmentName);
					attchment.setRegistrationId(currentUserProfile.getRegistrationId());
					attachement.save(attchment);
				    }
				}
			    } catch (IOException e) {
				e.printStackTrace();
			    }
			}
			return true;
		    } else {
			return false;
		    }
		}
		return true;
	    }

		    
	public Attachment getProfilePic(Integer registrationId) {
		
		Attachment attachment = null;
		if (registrationId != null) {
			String attchmentType = "profilePic";
			Attachment profilepicattachment = attachement.getProfilePicAttachment(registrationId, attchmentType);
			if(profilepicattachment!=null){
				return profilepicattachment;
			}
			
		}
		return attachment;
		
	
	}
				
}

