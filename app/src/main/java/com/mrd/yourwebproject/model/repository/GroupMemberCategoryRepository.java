/**
 * 
 */
package com.mrd.yourwebproject.model.repository;

import java.util.List;

import com.mrd.framework.data.BaseJpaRepository;
import com.mrd.yourwebproject.model.entity.GroupMemberCategory;

/**
 * @author mevan.d.souza
 *
 */
public interface GroupMemberCategoryRepository extends BaseJpaRepository<GroupMemberCategory, Long> {
	public List<GroupMemberCategory> findByGroupCode(String groupCode);
	public GroupMemberCategory findByMemberCategoryCode(String memberCategoryCode);

}
