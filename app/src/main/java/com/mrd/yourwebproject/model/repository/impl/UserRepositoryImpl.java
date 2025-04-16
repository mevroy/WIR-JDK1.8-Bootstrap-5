package com.mrd.yourwebproject.model.repository.impl;

import com.mrd.framework.data.BaseHibernateJpaRepository;
import com.mrd.yourwebproject.model.entity.User;
import com.mrd.yourwebproject.model.repository.UserRepository;

import org.hibernate.Filter;
import org.springframework.stereotype.Repository;

/**
 * User Repository implementation
 *
 * @author: Y Kamesh Rao
 * @created: 3/26/12 8:30 AM
 * @company: &copy; 2012, Kaleidosoft Labs
 */
@Repository
public class UserRepositoryImpl extends BaseHibernateJpaRepository<User, Long> implements UserRepository {

     public User findByEmail(String email) {
        return (User) sessionFactory.getCurrentSession().createQuery("from User u where u.email = ?1").setParameter(1,
                email).uniqueResult();
    }


     public User findByUsername(String username) {
        return (User) sessionFactory.getCurrentSession().createQuery("from User u where u.userName = ?1").setParameter(1,
                username).uniqueResult();
    }
     
     public User findByUsernameAndGroupCode(String username, String groupCode, boolean enableFilter) {
 
    	 if(enableFilter)
    	 {
    		 Filter filter = sessionFactory.getCurrentSession().enableFilter("filterUserRoles");
    		 filter.setParameter("groupCode", groupCode);
    	 }
         return (User) sessionFactory.getCurrentSession().createQuery("select u from User u left join u.groupUserRoles gur where u.userName = :userName and gur.group.groupCode = :gc and (gur.expiryDate is null or date(gur.expiryDate) >= NOW()) and (gur.startDate is null or date(gur.startDate) <= NOW())").setParameter("userName",
                 username).setParameter("gc", groupCode).uniqueResult();
     }
}
