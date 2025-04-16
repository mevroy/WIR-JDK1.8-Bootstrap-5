/**
 * 
 */
package com.mrd.yourwebproject.model.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mrd.framework.data.BaseHibernateJpaRepository;
import com.mrd.yourwebproject.model.entity.GroupEmailTemplate;
import com.mrd.yourwebproject.model.repository.GroupEmailTemplateRepository;

/**
 * @author mevan.d.souza
 *
 */
@Repository
public class GroupEmailTemplateRepositoryImpl extends
		BaseHibernateJpaRepository<GroupEmailTemplate, Long> implements GroupEmailTemplateRepository{

	public GroupEmailTemplate findbyTemplateName(String templateName) {
		return (GroupEmailTemplate)sessionFactory.getCurrentSession().createQuery("from GroupEmailTemplate get where get.templateName = ?1").setParameter(1,
                templateName).uniqueResult();
	}

	public List<GroupEmailTemplate> findbyGroupCode(String groupCode) {
		return (List<GroupEmailTemplate>)sessionFactory.getCurrentSession().createQuery("from GroupEmailTemplate get where get.groupCode = ?1 order by get.groupEventCode , get.templateName asc").setParameter(1,
				groupCode).list();
	}

	public List<GroupEmailTemplate> findbyGroupCodeAndGroupEventCode(
			String groupCode, String groupEventCode) {
		return (List<GroupEmailTemplate>)sessionFactory.getCurrentSession().createQuery("from GroupEmailTemplate get where get.groupCode = ?1 and (get.groupEventCode = ?2 or get.groupEventCode is null or get.groupEventCode = '') order by get.groupEventCode , get.templateName asc").setParameter(1,
				groupCode).setParameter(2, groupEventCode).list();
	}

}
