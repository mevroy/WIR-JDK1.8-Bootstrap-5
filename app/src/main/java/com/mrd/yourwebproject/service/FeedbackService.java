/**
 * 
 */
package com.mrd.yourwebproject.service;

import java.util.List;

import com.mrd.framework.data.BaseService;
import com.mrd.yourwebproject.model.entity.Feedback;
import com.mrd.yourwebproject.model.entity.GroupEventInvite;
import com.mrd.yourwebproject.model.entity.GroupMember;

/**
 * @author mevan.d.souza
 *
 */
public interface FeedbackService extends BaseService<Feedback, Long> {

	public List<Feedback> findByGroupEventCode(String groupEventCode);
	public List<Feedback> findByMemberCategoryCodeAndGroupEventCode(String memberCategoryCode, String groupEventCode);
	public Feedback findByGroupEventInvite(GroupEventInvite groupEventInvite);
	public List<Feedback> findByGroupMember(GroupMember groupMember);
}
