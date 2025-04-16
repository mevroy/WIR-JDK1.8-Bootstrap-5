/**
 * 
 */
package com.mrd.yourwebproject.service.impl;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mrd.framework.data.BaseJpaServiceImpl;
import com.mrd.yourwebproject.model.entity.GroupClientContact;
import com.mrd.yourwebproject.model.repository.GroupClientContactRepository;
import com.mrd.yourwebproject.service.GroupClientContactService;

/**
 * @author mevan.d.souza
 *
 */
@Service
@Transactional
public class GroupClientContactServiceImpl extends BaseJpaServiceImpl<GroupClientContact, String> implements GroupClientContactService {
	private @Autowired GroupClientContactRepository groupClientContactRepository;

	@PostConstruct
	public void setupService() {
		this.baseJpaRepository = groupClientContactRepository;
		this.entityClass = GroupClientContact.class;
		this.baseJpaRepository.setupEntityClass(GroupClientContact.class);
	}

	public List<GroupClientContact> findByGroupClient(String clientId) {
		return groupClientContactRepository.findByGroupClient(clientId);
	}

}
