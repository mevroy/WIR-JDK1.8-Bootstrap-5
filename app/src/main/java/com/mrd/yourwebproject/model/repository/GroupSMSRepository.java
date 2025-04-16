/**
 * 
 */
package com.mrd.yourwebproject.model.repository;

import java.util.List;

import com.mrd.framework.data.BaseJpaRepository;
import com.mrd.yourwebproject.model.entity.GroupSMS;

/**
 * @author mevan.d.souza
 *
 */
public interface GroupSMSRepository extends BaseJpaRepository<GroupSMS, String> {

	public List<GroupSMS> findByGroupCode(String groupCode);
	public GroupSMS findByMessageId(String messageId);
	public List<GroupSMS> findSMSByGroupEventCode(String groupEventCode);
	public List<GroupSMS> findSMSByMemberCategoryCodeAndGroupEventCode(String memberCategoryCode, String groupEventCode);
	public List<GroupSMS> findUnassignedSMSByGroupCode(String groupCode);
	
}
