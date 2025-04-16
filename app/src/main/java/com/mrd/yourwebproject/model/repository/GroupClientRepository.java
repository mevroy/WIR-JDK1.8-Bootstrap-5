/**
 * 
 */
package com.mrd.yourwebproject.model.repository;

import java.util.List;

import com.mrd.framework.data.BaseJpaRepository;
import com.mrd.yourwebproject.model.entity.GroupClient;

/**
 * @author mevan.d.souza
 *
 */
public interface GroupClientRepository extends BaseJpaRepository<GroupClient, String> {


	public List<GroupClient> findByGroupCode(String groupCode);
	
}
