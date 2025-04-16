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
import com.mrd.yourwebproject.model.entity.GroupClient;
import com.mrd.yourwebproject.model.repository.GroupClientRepository;
import com.mrd.yourwebproject.service.GroupClientService;

/**
 * @author mevan.d.souza
 *
 */
@Service
@Transactional
public class GroupClientServiceImpl extends BaseJpaServiceImpl<GroupClient, String> implements GroupClientService {
	private @Autowired GroupClientRepository groupClientRepository;

	@PostConstruct
	public void setupService() {
		this.baseJpaRepository = groupClientRepository;
		this.entityClass = GroupClient.class;
		this.baseJpaRepository.setupEntityClass(GroupClient.class);
	}

	public List<GroupClient> findByGroupCode(String groupCode) {
		return groupClientRepository.findByGroupCode(groupCode);
	}

}
