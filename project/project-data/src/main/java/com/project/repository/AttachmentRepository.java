package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.model.Attachment;

public interface AttachmentRepository extends JpaRepository<Attachment, Integer> {

	@Query("select attachment from Attachment attachment where attachment.registrationId=:regId and attachment.attachmentType=:attachmentType")
	Attachment getProfilePicAttachment(@Param("regId")Integer registrationId,@Param("attachmentType") String attachmentType);
	
}
