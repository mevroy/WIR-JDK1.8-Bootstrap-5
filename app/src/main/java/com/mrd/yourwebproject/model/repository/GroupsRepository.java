/**
 * 
 */
package com.mrd.yourwebproject.model.repository;

import java.util.List;

import com.mrd.framework.data.BaseJpaRepository;
import com.mrd.yourwebproject.model.entity.Groups;

/**
 * @author mevan.d.souza
 *
 */
public interface GroupsRepository extends BaseJpaRepository<Groups, Long> {

	public Groups findByGroupCode(String groupCode);
	public Groups findByGroupCodeActive(String groupCode);
	public List<Groups> findGroups();
	
}
