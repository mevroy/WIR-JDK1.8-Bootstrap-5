/**
 * 
 */
package com.mrd.yourwebproject.service;

import java.util.List;

import com.mrd.framework.data.BaseService;
import com.mrd.yourwebproject.model.entity.GroupMemberCategory;

/**
 * @author mevan.d.souza
 *
 */
public interface GroupMemberCategoryService extends BaseService<GroupMemberCategory, Long>{

	public List<GroupMemberCategory> findByGroupCode(String groupCode);
	public GroupMemberCategory findByMemberCategoryCode(String memberCategoryCode);
}
