/**
 * 
 */
package com.mrd.yourwebproject.service;

import com.mrd.yourwebproject.model.entity.GroupPushNotificationAccount;

/**
 * @author mevan.d.souza
 *
 */
public interface PushedApiService {

	public String sendPushedNotification(String content, GroupPushNotificationAccount groupPushNotficationAccount);
	public String sendPushedNotification(String content, String groupEmailId);
}
