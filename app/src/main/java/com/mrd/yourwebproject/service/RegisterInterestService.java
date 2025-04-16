/**
 * 
 */
package com.mrd.yourwebproject.service;

import java.util.List;

import com.mrd.framework.data.BaseService;
import com.mrd.yourwebproject.model.entity.RegisterInterest;

/**
 * @author mevan.d.souza
 *
 */
public interface RegisterInterestService extends BaseService<RegisterInterest, Long>{
	public List<RegisterInterest> findByGroupCode(String groupCode, boolean includeAll);
}
