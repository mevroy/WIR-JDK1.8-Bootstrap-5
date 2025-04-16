/**
 * 
 */
package com.mrd.yourwebproject.model.repository;

import java.util.List;

import com.mrd.framework.data.BaseJpaRepository;
import com.mrd.yourwebproject.model.entity.GroupInboundSMS;


/**
 * @author mevan.d.souza
 *
 */
public interface GroupInboundSMSRepository extends BaseJpaRepository<GroupInboundSMS, String> {

	public List<GroupInboundSMS> findByGroupCode(String groupCode);
	public List<GroupInboundSMS> findByMessageId(String messageId);
	
}
