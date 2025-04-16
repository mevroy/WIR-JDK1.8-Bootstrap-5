/**
 * 
 */
package com.mrd.yourwebproject.model.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mrd.framework.data.BaseHibernateJpaRepository;
import com.mrd.yourwebproject.model.entity.GroupContent;
import com.mrd.yourwebproject.model.repository.GroupContentRepository;

/**
 * @author mevan.d.souza
 *
 */
@Repository
public class GroupContentRepositoryImpl extends BaseHibernateJpaRepository<GroupContent, String> implements GroupContentRepository{

	public List<GroupContent> findByGroupCode(String groupCode, boolean includeExpired) {
		return (List<GroupContent>)sessionFactory.getCurrentSession().createQuery("from GroupContent g where g.group.groupCode = ?1 "+(includeExpired?"":" and ((g.expiryDate is null or g.expiryDate >= NOW()) and (g.startDate is null or (g.startDate) <= NOW()))")).setParameter(1,
                groupCode).list();
	}


}
