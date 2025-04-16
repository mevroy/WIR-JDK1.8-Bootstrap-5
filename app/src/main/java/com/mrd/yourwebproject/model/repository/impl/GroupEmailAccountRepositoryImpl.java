/**
 * 
 */
package com.mrd.yourwebproject.model.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mrd.framework.data.BaseHibernateJpaRepository;
import com.mrd.yourwebproject.model.entity.GroupEmailAccount;
import com.mrd.yourwebproject.model.repository.GroupEmailAccountRepository;

/**
 * @author mevan.d.souza
 *
 */
@Repository
public class GroupEmailAccountRepositoryImpl extends
		BaseHibernateJpaRepository<GroupEmailAccount, Long>  implements GroupEmailAccountRepository{

	public GroupEmailAccount findByEmailAccountCode(String emailAccountCode) {
		return (GroupEmailAccount)sessionFactory.getCurrentSession().createQuery("from GroupEmailAccount gea where gea.emailAccountCode = ?1").setParameter(1,
				emailAccountCode).uniqueResult();
	}

	public List<GroupEmailAccount> findByGroupCode(String groupCode) {
		return (List<GroupEmailAccount>)sessionFactory.getCurrentSession().createQuery("from GroupEmailAccount gea where gea.groupCode = ?1").setParameter(1,
				groupCode).list();
	}

}
