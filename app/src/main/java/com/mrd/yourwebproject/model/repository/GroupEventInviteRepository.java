/**
 * 
 */
package com.mrd.yourwebproject.model.repository;

import java.util.List;

import com.mrd.framework.data.BaseJpaRepository;
import com.mrd.yourwebproject.model.entity.GroupEventInvite;
import com.mrd.yourwebproject.model.entity.GroupEvents;
import com.mrd.yourwebproject.model.entity.GroupMember;

/**
 * @author mevan.d.souza
 *
 */
public interface GroupEventInviteRepository extends BaseJpaRepository<GroupEventInvite, String> {

	public List<GroupEventInvite> findByGroupCodeAndCategoryCodeAndEventCode(String groupCode, String memberCategoryCode, String eventCode);
	public List<GroupEventInvite> findByGroupCodeAndEventCode(String groupCode, String eventCode);
	public List<GroupEventInvite> findByGroupMember(GroupMember groupMember);
	public GroupEventInvite findByGroupMemberAndGroupEvent(GroupMember groupMember, GroupEvents groupEvent);
	public GroupEventInvite findByGroupEventInviteCode(String groupEventInviteCode);
}
