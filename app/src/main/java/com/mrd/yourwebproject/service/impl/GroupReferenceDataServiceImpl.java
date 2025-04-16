/**
 * 
 */
package com.mrd.yourwebproject.service.impl;

import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mrd.framework.data.BaseJpaServiceImpl;
import com.mrd.yourwebproject.model.entity.GroupReferenceData;
import com.mrd.yourwebproject.model.repository.GroupReferenceDataRepository;
import com.mrd.yourwebproject.service.GroupReferenceDataService;

/**
 * @author mevan.d.souza
 *
 */
@Service
@Transactional
public class GroupReferenceDataServiceImpl extends BaseJpaServiceImpl<GroupReferenceData, Long>
		implements GroupReferenceDataService {
	private @Autowired GroupReferenceDataRepository groupReferenceDataRepository;

	@PostConstruct
	public void setupService() {
		this.baseJpaRepository = groupReferenceDataRepository;
		this.entityClass = GroupReferenceData.class;
		this.baseJpaRepository.setupEntityClass(GroupReferenceData.class);
	}

	public GroupReferenceData findByReferenceDataType(String referenceDataType) {

		return groupReferenceDataRepository.findByReferenceDataType(referenceDataType);
	}

	
	public List<GroupReferenceData> findByGroupCode(String groupCode) {
		return groupReferenceDataRepository.findByGroupCode(groupCode);
	}

	public GroupReferenceData retrieveAndLockReferenceData(String referenceDataType) {
		synchronized (this) {
			GroupReferenceData grd = groupReferenceDataRepository.findByReferenceDataType(referenceDataType);
			grd.setUpdatedAt(Calendar.getInstance().getTime());
			String value = StringUtils.isNotBlank(grd.getReferenceDataValue())?grd.getReferenceDataValue():"0";
			long longValue = Long.valueOf(value);
			longValue++;
			String newValue = StringUtils.leftPad(String.valueOf(longValue),grd.getSize(),grd.getPaddingCharacter());
			grd.setReferenceDataValue(newValue);
			return groupReferenceDataRepository.update(grd);
		}
	}

}
