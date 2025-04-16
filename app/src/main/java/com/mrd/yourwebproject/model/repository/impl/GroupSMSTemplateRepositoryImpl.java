/**
 * 
 */
package com.mrd.yourwebproject.model.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mrd.framework.data.BaseHibernateJpaRepository;
import com.mrd.yourwebproject.model.entity.GroupSMSTemplate;
import com.mrd.yourwebproject.model.repository.GroupSMSTemplateRepository;

/**
 * @author mevan.d.souza
 *
 */
@Repository
public class GroupSMSTemplateRepositoryImpl extends
		BaseHibernateJpaRepository<GroupSMSTemplate, Long> implements GroupSMSTemplateRepository{

	public GroupSMSTemplate findbyTemplateName(String templateName) {
		return (GroupSMSTemplate)sessionFactory.getCurrentSession().createQuery("from GroupSMSTemplate get where get.templateName = ?1").setParameter(1,
                templateName).uniqueResult();
	}

	public List<GroupSMSTemplate> findbyGroupCode(String groupCode) {
		return (List<GroupSMSTemplate>)sessionFactory.getCurrentSession().createQuery("from GroupSMSTemplate get where get.group.groupCode = ?1 order by get.groupEventCode , get.templateName asc").setParameter(1,
				groupCode).list();
	}

	public List<GroupSMSTemplate> findbyGroupCodeAndGroupEventCode(
			String groupCode, String groupEventCode) {
		return (List<GroupSMSTemplate>)sessionFactory.getCurrentSession().createQuery("from GroupSMSTemplate get where get.group.groupCode = ?1 and (get.groupEventCode = ?2 or get.groupEventCode is null or get.groupEventCode = '') order by get.groupEventCode , get.templateName asc").setParameter(1,
				groupCode).setParameter(2, groupEventCode).list();
	}

}
