/**
 * 
 */
package com.mrd.yourwebproject.model.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mrd.framework.data.BaseHibernateJpaRepository;
import com.mrd.yourwebproject.model.entity.ExternalScanner;
import com.mrd.yourwebproject.model.repository.ExternalScannerRepository;

/**
 * @author mevan.d.souza
 *
 */
@Repository
public class ExternalScannerRepositoryImpl extends BaseHibernateJpaRepository<ExternalScanner, Long> implements ExternalScannerRepository{

	public ExternalScanner findBydeviceUuid(String groupCode, String deviceUuid) {
		return (ExternalScanner)sessionFactory.getCurrentSession().createQuery("from ExternalScanner es where es.groupCode = ?1 and es.deviceUuid = ?2").setParameter(1,
                groupCode).setParameter(2, deviceUuid).uniqueResult();
	}


	public List<ExternalScanner> findByGroupCode(String groupCode) {
		return (List<ExternalScanner>)sessionFactory.getCurrentSession().createQuery("from ExternalScanner es where es.groupCode = ?1 ").setParameter(1,
                groupCode).list();
	}

}
