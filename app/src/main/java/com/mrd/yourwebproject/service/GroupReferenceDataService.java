/**
 * 
 */
package com.mrd.yourwebproject.service;

import java.util.List;

import com.mrd.framework.data.BaseService;
import com.mrd.yourwebproject.model.entity.GroupReferenceData;

/**
 * @author mevan.d.souza
 *
 */
public interface GroupReferenceDataService extends BaseService<GroupReferenceData, Long> {

	public GroupReferenceData findByReferenceDataType(String referenceDataType);
	public List<GroupReferenceData> findByGroupCode(String groupCode);
	public GroupReferenceData retrieveAndLockReferenceData(String referenceDataType);
}
