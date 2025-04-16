/**
 * 
 */
package com.mrd.yourwebproject.model.repository;

import java.util.List;

import com.mrd.framework.data.BaseJpaRepository;
import com.mrd.yourwebproject.model.entity.GroupContent;

/**
 * @author mevan.d.souza
 *
 */
public interface GroupContentRepository extends BaseJpaRepository<GroupContent, String> {

	public List<GroupContent> findByGroupCode(String groupCode, boolean includeExpired);
	
}
