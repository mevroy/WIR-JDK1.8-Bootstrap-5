/**
 * 
 */
package com.mrd.yourwebproject.model.repository;

import java.util.List;

import com.mrd.framework.data.BaseJpaRepository;
import com.mrd.yourwebproject.model.entity.GroupEvents;

/**
 * @author mevan.d.souza
 *
 */
public interface GroupEventsRepository extends BaseJpaRepository<GroupEvents, Long> {

	public List<GroupEvents> findByGroupCode(String groupCode);
	public List<GroupEvents> findByGroupCodeAndMemberCategoryCode(String groupCode, String memberCategoryCode);
	public List<GroupEvents> findByGroupCode(String groupCode, boolean includeExpired);
	public List<GroupEvents> findByGroupCodeAndMemberCategoryCode(String groupCode, String memberCategoryCode, boolean includeExpired);
	public GroupEvents findByGroupEventCode(String groupEventCode);
}
