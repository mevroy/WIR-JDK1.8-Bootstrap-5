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
import com.mrd.yourwebproject.model.repository.GroupEmailTemplateRepository;
import com.mrd.yourwebproject.service.GroupEmailTemplateService;

/**
 * @author mevan.d.souza
 *
 */
@Service
@Transactional
public class GroupEmailTemplateServiceImpl extends
		BaseJpaServiceImpl<GroupEmailTemplate, Long> implements
		GroupEmailTemplateService {

	private @Autowired GroupEmailTemplateRepository groupEmailTemplateRepository;

	@PostConstruct
	public void setupService() {
		this.baseJpaRepository = groupEmailTemplateRepository;
		this.entityClass = GroupEmailTemplate.class;
		this.baseJpaRepository.setupEntityClass(GroupEmailTemplate.class);

	}

	public GroupEmailTemplate findbyTemplateName(String templateName) {
		return groupEmailTemplateRepository.findbyTemplateName(templateName);
	}

	public List<GroupEmailTemplate> findbyGroupCode(String groupCode) {

		return groupEmailTemplateRepository.findbyGroupCode(groupCode);
	}

	public List<GroupEmailTemplate> findbyGroupCodeAndGroupEventCode(
			String groupCode, String groupEventCode) {
		return groupEmailTemplateRepository.findbyGroupCodeAndGroupEventCode(
				groupCode, groupEventCode);
	}

}
