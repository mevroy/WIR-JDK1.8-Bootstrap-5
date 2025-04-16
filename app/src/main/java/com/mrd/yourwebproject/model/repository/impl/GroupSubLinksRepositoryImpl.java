/**
 * 
 */
package com.mrd.yourwebproject.model.repository.impl;

import java.util.List;


import org.springframework.stereotype.Repository;

import com.mrd.framework.data.BaseHibernateJpaRepository;
import com.mrd.yourwebproject.model.entity.GroupMainLink;
import com.mrd.yourwebproject.model.entity.GroupSubLink;
import com.mrd.yourwebproject.model.repository.GroupSubLinksRepository;

/**
 * @author mevan.d.souza
 *
 */
@Repository
public class GroupSubLinksRepositoryImpl extends BaseHibernateJpaRepository<GroupSubLink, String> implements GroupSubLinksRepository{


	public List<GroupSubLink> findByGroupMainLink(GroupMainLink groupMainLink,
			boolean includeDisabled) {

		return (List<GroupSubLink>)sessionFactory.getCurrentSession().createQuery("from GroupSubLink g where g.groupMainLink = :groupMainLink "+(includeDisabled?"":" and g.disabled = false ")).setParameter("groupMainLink", groupMainLink).list();
	}

	public List<GroupSubLink> findByURL(String url, boolean includeDisabled) {
		return (List<GroupSubLink>)sessionFactory.getCurrentSession().createQuery("from GroupSubLink g where g.linkHref = :url "+(includeDisabled?"":" and g.disabled = false ")).setParameter("url", url).list();
	}

}
