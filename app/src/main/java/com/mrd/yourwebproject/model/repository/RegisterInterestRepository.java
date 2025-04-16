/**
 * 
 */
package com.mrd.yourwebproject.model.repository;

import java.util.List;

import com.mrd.framework.data.BaseJpaRepository;
import com.mrd.yourwebproject.model.entity.RegisterInterest;

/**
 * @author mevan.d.souza
 *
 */
public interface RegisterInterestRepository extends BaseJpaRepository<RegisterInterest, Long> {

	public List<RegisterInterest> findByGroupCode(String groupCode, boolean includeAll); 
	
}
