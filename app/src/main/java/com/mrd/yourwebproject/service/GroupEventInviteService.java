/**
 * 
 */
package com.mrd.yourwebproject.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import com.mrd.framework.data.BaseService;
import com.mrd.yourwebproject.model.entity.GroupEventInvite;
import com.mrd.yourwebproject.model.entity.GroupEventPass;
import com.mrd.yourwebproject.model.entity.GroupEvents;
import com.mrd.yourwebproject.model.entity.GroupMember;

/**
 * @author mevan.d.souza
 *
 */
public interface GroupEventInviteService extends BaseService<GroupEventInvite, String> {

	public List<GroupEventInvite> findByGroupCodeAndCategoryCodeAndEventCode(String groupCode, String memberCategoryCode, String eventCode);
	public List<GroupEventInvite> findByGroupCodeAndEventCode(String groupCode, String eventCode);
	public List<GroupEventInvite> findByGroupMember(GroupMember groupMember);
	public GroupEventInvite findByGroupMemberAndGroupEvent(GroupMember groupMember, GroupEvents groupEvent);
	public GroupEventInvite findByGroupEventInviteCode(String groupEventInviteCode);
	public ByteArrayOutputStream generateTicketPDF(GroupEventInvite gei, List<GroupEventPass> groupEventPasses) throws IOException;
}
