/**
 * 
 */
package com.mrd.yourwebproject.service;

import java.util.List;

import com.mrd.framework.data.BaseService;
import com.mrd.yourwebproject.model.entity.GroupEvents;

/**
 * @author mevan.d.souza
 *
 */
public interface GroupEventsService extends BaseService<GroupEvents, Long> {

	public List<GroupEvents> findByGroupCode(String groupCode);
	public List<GroupEvents> findByGroupCodeAndMemberCategoryCode(String groupCode, String memberCategoryCode);
	public List<GroupEvents> findByGroupCode(String groupCode, boolean includeExpired);
	public List<GroupEvents> findByGroupCodeAndMemberCategoryCode(String groupCode, String memberCategoryCode, boolean includeExpired);
	public GroupEvents findByGroupEventCode(String groupEventCode);
}
