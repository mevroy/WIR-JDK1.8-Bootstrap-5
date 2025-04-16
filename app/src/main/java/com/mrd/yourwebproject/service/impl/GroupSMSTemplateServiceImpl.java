/**
 * 
 */
package com.mrd.yourwebproject.service.impl;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mrd.framework.data.BaseJpaServiceImpl;
import com.mrd.yourwebproject.model.entity.GroupEmailTemplate;
import com.mrd.yourwebproject.model.entity.GroupSMSTemplate;
import com.mrd.yourwebproject.model.repository.GroupEmailTemplateRepository;
import com.mrd.yourwebproject.model.repository.GroupSMSTemplateRepository;
import com.mrd.yourwebproject.service.GroupEmailTemplateService;
import com.mrd.yourwebproject.service.GroupSMSTemplateService;

/**
 * @author mevan.d.souza
 *
 */
@Service
@Transactional
public class GroupSMSTemplateServiceImpl extends
		BaseJpaServiceImpl<GroupSMSTemplate, Long> implements
		GroupSMSTemplateService {

	private @Autowired GroupSMSTemplateRepository groupSMSTemplateRepository;

	@PostConstruct
	public void setupService() {
		this.baseJpaRepository = groupSMSTemplateRepository;
		this.entityClass = GroupSMSTemplate.class;
		this.baseJpaRepository.setupEntityClass(GroupSMSTemplate.class);

	}

	public GroupSMSTemplate findbyTemplateName(String templateName) {
		return groupSMSTemplateRepository.findbyTemplateName(templateName);
	}

	public List<GroupSMSTemplate> findbyGroupCode(String groupCode) {

		return groupSMSTemplateRepository.findbyGroupCode(groupCode);
	}

	public List<GroupSMSTemplate> findbyGroupCodeAndGroupEventCode(
			String groupCode, String groupEventCode) {
		return groupSMSTemplateRepository.findbyGroupCodeAndGroupEventCode(
				groupCode, groupEventCode);
	}

}
