/**
 * 
 */
package com.mrd.yourwebproject.service;

import java.util.List;

import com.mrd.framework.data.BaseService;
import com.mrd.yourwebproject.model.entity.GroupContent;
import com.mrd.yourwebproject.model.entity.GroupInboundSMS;
import com.mrd.yourwebproject.model.entity.GroupSMS;


/**
 * @author mevan.d.souza
 *
 */
public interface GroupInboundSMSService extends BaseService<GroupInboundSMS, String> {

	public List<GroupInboundSMS> findByGroupCode(String groupCode);
	public List<GroupInboundSMS> findByMessageId(String messageId);
}
