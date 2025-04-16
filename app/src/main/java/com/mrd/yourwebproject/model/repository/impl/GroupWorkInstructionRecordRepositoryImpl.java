/**
 * 
 */
package com.mrd.yourwebproject.model.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mrd.framework.data.BaseHibernateJpaRepository;
import com.mrd.yourwebproject.model.entity.GroupWorkInstructionRecord;
import com.mrd.yourwebproject.model.entity.User;
import com.mrd.yourwebproject.model.repository.GroupWorkInstructionRecordRepository;

/**
 * @author mevan.d.souza
 *
 */
@Repository
public class GroupWorkInstructionRecordRepositoryImpl extends
		BaseHibernateJpaRepository<GroupWorkInstructionRecord, Long> implements GroupWorkInstructionRecordRepository {

	public List<GroupWorkInstructionRecord> findByGroupCodeAndUser(String groupCode, User user) {
		return (List<GroupWorkInstructionRecord>) sessionFactory.getCurrentSession().createQuery(
				"select gwir from GroupWorkInstructionRecord gwir where gwir.group.groupCode = :groupCode and gwir.user.userId = :userId")
				.setParameter("groupCode", groupCode).setParameter("userId", user.getId()).list();
	}

	public List<GroupWorkInstructionRecord> findByGroupCode(String groupCode) {
		return (List<GroupWorkInstructionRecord>) sessionFactory.getCurrentSession()
				.createQuery("select gwir from GroupWorkInstructionRecord gwir where gwir.group.groupCode = :groupCode")
				.setParameter("groupCode", groupCode).list();
	}

}
