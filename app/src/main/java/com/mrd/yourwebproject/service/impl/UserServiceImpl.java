package com.mrd.yourwebproject.service.impl;

import com.mrd.framework.data.BaseJpaServiceImpl;
import com.mrd.framework.exception.database.NotFoundException;
import com.mrd.framework.validation.EntityValidator;
import com.mrd.framework.validation.Validity;
import com.mrd.yourwebproject.common.Key;
import com.mrd.yourwebproject.common.Message;
import com.mrd.yourwebproject.model.entity.User;
import com.mrd.yourwebproject.model.repository.UserRepository;
import com.mrd.yourwebproject.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import java.util.Date;

/**
 * Service impl class to implement services for accessing the User object entity.
 * This class acts as an interface between the outer world and the UserRepository
 *
 * @author: Y Kamesh Rao
 * @created: 3/25/12 11:05 AM
 * @company: &copy; 2012, Kaleidosoft Labs
 */
@Service
@Transactional
public class UserServiceImpl extends BaseJpaServiceImpl<User, Long> implements UserService {
    private @Autowired UserRepository userRepository;
    private @Autowired Message msg;
    private @Autowired Key key;


    @PostConstruct
    public void setupService() {
        this.baseJpaRepository = userRepository;
        this.entityClass = User.class;
        this.baseJpaRepository.setupEntityClass(User.class);
    }


     public boolean isValidPass(User user, String pass) {
        return user.getPassWord().equals(User.hashPassword(pass));
    }


     public User registerUser(User user, HttpServletRequest request) {
        user.setPassWord(User.hashPassword(user.getPassWord()));
        user.setCurrentLoginAt(new Date());
		   String ipAddress = request.getHeader("X-FORWARDED-FOR");  
		   if (ipAddress == null) {  
			   ipAddress = request.getRemoteAddr();  
		   }
        user.setCurrentLoginIp(ipAddress);
        user.setLoginCount(0);
        return userRepository.insert(user);
    }


     public User loginUser(final User user, final HttpServletRequest request) {
        user.setLastLoginAt(user.getCurrentLoginAt());
        user.setLastLoginIp(user.getCurrentLoginIp());
        user.setCurrentLoginAt(new Date());
		   String ipAddress = request.getHeader("X-FORWARDED-FOR");  
		   if (ipAddress == null) {  
			   ipAddress = request.getRemoteAddr();  
		   }
        user.setCurrentLoginIp(ipAddress);
        user.setLoginCount(user.getLoginCount() + 1);
        user.setUpdatedAt(new Date());

        return userRepository.update(user);
    }


     public boolean isUsernameExists(String username) {
        if (userRepository.findByUsername(username) != null) {
            return true;
        } else
            return false;
    }


     public boolean isEmailExists(String email) {
        if (userRepository.findByEmail(email) != null) {
            return true;
        } else
            return false;
    }


     public Validity validate(User user) {
        EntityValidator<User> entityValidator = new EntityValidator<User>();
        Validity validity = entityValidator.validate(user, User.class);

        // Check for username and email uniqueness
        if (isUsernameExists(user.getUserName())) {
            validity.addError(msg.userExists);
        }

        if (isEmailExists(user.getEmail())) {
            validity.addError(msg.emailExists);
        }

        return validity;
    }


     public User findByUsername(String username) throws NotFoundException {
        User user = userRepository.findByUsername(username);

        if(user != null) {
            return user;
        } else {
            throw new NotFoundException(key.unfMsg, key.unfCode);
        }
    }


	public User findByUsernameAndGroupCode(String username, String groupCode,boolean enableFilter) throws NotFoundException {
		User user = userRepository.findByUsernameAndGroupCode(username, groupCode,enableFilter);
        if(user != null) {
            return user;
        } else {
        	
            throw new NotFoundException(key.unfMsg, key.unfCode);
        }
	}
}
