/**
 * 
 */
package com.mrd.yourwebproject.service;

import java.util.List;

import com.mrd.framework.data.BaseService;
import com.mrd.yourwebproject.model.entity.GroupSMSTemplate;

/**
 * @author mevan.d.souza
 *
 */
public interface GroupSMSTemplateService extends BaseService<GroupSMSTemplate, Long> {

	public GroupSMSTemplate findbyTemplateName(String templateName);
	public List<GroupSMSTemplate> findbyGroupCode(String groupCode);
	public List<GroupSMSTemplate> findbyGroupCodeAndGroupEventCode(String groupCode, String groupEventCode);
	
}
