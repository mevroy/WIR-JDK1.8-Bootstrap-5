/**
 * 
 */
package com.mrd.yourwebproject.model.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mrd.framework.data.BaseHibernateJpaRepository;
import com.mrd.yourwebproject.common.Props;
import com.mrd.yourwebproject.model.entity.GroupEmailActivity;
import com.mrd.yourwebproject.model.repository.GroupEmailActivityRepository;


/**
 * @author mevan.d.souza
 *
 */
@Repository
public class GroupEmailActivityRepositoryImpl extends BaseHibernateJpaRepository<GroupEmailActivity, Long> implements GroupEmailActivityRepository{

	protected @Autowired Props props;
	public List<GroupEmailActivity> findEmailActivitiesByEmailId(String groupEmailId) {
		return (List<GroupEmailActivity>)sessionFactory.getCurrentSession().createQuery("from GroupEmailActivity gea where gea.groupEmail.groupEmailId = :groupEmailId order by activityTime asc").setParameter("groupEmailId", groupEmailId).list();

	}



}
