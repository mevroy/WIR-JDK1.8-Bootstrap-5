/**
 * 
 */
package com.mrd.yourwebproject.model.repository;

import java.util.List;

import com.mrd.framework.data.BaseJpaRepository;
import com.mrd.yourwebproject.model.entity.GroupReferenceData;

/**
 * @author mevan.d.souza
 *
 */
public interface GroupReferenceDataRepository extends BaseJpaRepository<GroupReferenceData, Long> {

	public GroupReferenceData findByReferenceDataType(String referenceDataType);
	public List<GroupReferenceData> findByGroupCode(String groupCode);
	
}
