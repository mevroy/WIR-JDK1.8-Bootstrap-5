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
import com.mrd.yourwebproject.model.entity.GroupEmailAccount;
import com.mrd.yourwebproject.model.repository.GroupEmailAccountRepository;
import com.mrd.yourwebproject.service.GroupEmailAccountService;

/**
 * @author mevan.d.souza
 *
 */
@Service
@Transactional
public class GroupEmailAccountServiceImpl extends
		BaseJpaServiceImpl<GroupEmailAccount, Long> implements
		GroupEmailAccountService {
	private @Autowired GroupEmailAccountRepository groupEmailAccountRepository;

	@PostConstruct
	public void setupService() {
		this.baseJpaRepository = groupEmailAccountRepository;
		this.entityClass = GroupEmailAccount.class;
		this.baseJpaRepository.setupEntityClass(GroupEmailAccount.class);

	}

	public GroupEmailAccount findByEmailAccountCode(String emailAccountCode) {

		return groupEmailAccountRepository
				.findByEmailAccountCode(emailAccountCode);
	}

	public List<GroupEmailAccount> findByGroupCode(String groupCode) {

		return groupEmailAccountRepository.findByGroupCode(groupCode);
	}

}
