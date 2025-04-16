/**
 * 
 */
package com.mrd.yourwebproject.service;

import java.util.List;

import com.mrd.yourwebproject.model.entity.SmsApiResponseEntity;



/**
 * @author mevan.d.souza
 *
 */
public interface SmsApiService {

//	public String sendSmsNotification(String content, GroupPushNotificationAccount groupPushNotficationAccount);
	public SmsApiResponseEntity sendSmsNotification(String phoneNumber, String content) throws Exception;
	public SmsApiResponseEntity sendSmsNotification(List<String> phoneNumbers, String content) throws Exception;
	public SmsApiResponseEntity getSmsNotificationStatus(String messageId);
}
