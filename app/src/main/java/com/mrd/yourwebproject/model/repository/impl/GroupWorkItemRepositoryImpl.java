/**
 * 
 */
package com.mrd.yourwebproject.model.repository.impl;

import org.springframework.stereotype.Repository;

import com.mrd.framework.data.BaseHibernateJpaRepository;
import com.mrd.yourwebproject.model.entity.GroupWorkItems;
import com.mrd.yourwebproject.model.repository.GroupWorkItemRepository;

/**
 * @author mevan.d.souza
 *
 */
@Repository
public class GroupWorkItemRepositoryImpl extends
		BaseHibernateJpaRepository<GroupWorkItems, Long> implements GroupWorkItemRepository {

}
