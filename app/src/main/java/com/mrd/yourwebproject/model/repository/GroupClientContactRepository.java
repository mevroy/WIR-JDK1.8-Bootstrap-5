/**
 * 
 */
package com.mrd.yourwebproject.model.repository;

import java.util.List;

import com.mrd.framework.data.BaseJpaRepository;
import com.mrd.yourwebproject.model.entity.GroupClientContact;

/**
 * @author mevan.d.souza
 *
 */
public interface GroupClientContactRepository extends BaseJpaRepository<GroupClientContact, String> {


	public List<GroupClientContact> findByGroupClient(String clientId);
	
}
