/**
 * 
 */
package com.mrd.yourwebproject.model.repository;

import java.util.List;

import com.mrd.framework.data.BaseJpaRepository;
import com.mrd.yourwebproject.model.entity.Feedback;
import com.mrd.yourwebproject.model.entity.GroupEventInvite;
import com.mrd.yourwebproject.model.entity.GroupMember;

/**
 * @author mevan.d.souza
 *
 */
public interface FeedbackRepository extends BaseJpaRepository<Feedback, Long> {

	public List<Feedback> findByGroupEventCode(String groupEventCode);
	public List<Feedback> findByMemberCategoryCodeAndGroupEventCode(String memberCategoryCode, String groupEventCode);
	public Feedback findByGroupEventInvite(GroupEventInvite groupEventInvite);
	public List<Feedback> findByGroupMember(GroupMember groupMember);
	
}
