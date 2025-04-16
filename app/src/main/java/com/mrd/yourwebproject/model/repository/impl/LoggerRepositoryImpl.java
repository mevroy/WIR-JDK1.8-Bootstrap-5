/**
 * 
 */
package com.mrd.yourwebproject.model.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mrd.framework.data.BaseHibernateJpaRepository;
import com.mrd.yourwebproject.model.entity.AuditLog;
import com.mrd.yourwebproject.model.entity.User;
import com.mrd.yourwebproject.model.repository.LoggerRepository;

/**
 * @author mevan.d.souza
 *
 */
@Repository
public class LoggerRepositoryImpl extends BaseHibernateJpaRepository<AuditLog, Long> implements LoggerRepository{

	public List<AuditLog> findByGroupCode(String groupCode) {
		return (List<AuditLog>)sessionFactory.getCurrentSession().createQuery("from AuditLog a where a.groupCode = ?1 or a.groupCode = null order by accessDate desc").setParameter(1,
				groupCode).list();
	}


	public List<AuditLog> findByUser(User user, String groupCode) {
		return (List<AuditLog>)sessionFactory.getCurrentSession().createQuery("from AuditLog a where a.user = ?1 or a.groupCode = null order by accessDate desc").setParameter(1,
				user).list();
	}


	public List<AuditLog> findByGroupCodeAndRequestURIAndMethod(String groupCode,
			String requestURI, String method) {
		return (List<AuditLog>)sessionFactory.getCurrentSession().createQuery("from AuditLog a where a.groupCode = ?1 and a.requestURI = ?2 and a.method = ?3 order by accessDate desc").setParameter(1,
				groupCode).setParameter(2, requestURI).setParameter(3, method).list();
	}


}
