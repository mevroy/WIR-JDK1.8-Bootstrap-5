package com.mrd.yourwebproject.actor;

import java.util.Map;

import org.springframework.mail.MailAuthenticationException;

import com.mrd.framework.exception.service.NotYetImplementedException;
import com.mrd.yourwebproject.model.entity.GroupEmail;
import com.mrd.yourwebproject.model.entity.GroupEmailAccount;
import com.mrd.yourwebproject.model.entity.User;

/**
 * Typed Actor to offload the mail sending activity
 * of the current thread
 *
 * @author: Y Kamesh Rao
 * @created: 4/21/12 5:27 PM
 * @company: &copy; 2012, Kaleidosoft Labs
 */
public interface SMSSenderUntypedActor {
	
	public String prepareSMSBody(final String templateName, Map<String, Object> model);
	

/*	public String preparePushNotificationsBody(final String templateName, Map<String, Object> model);*/
}
