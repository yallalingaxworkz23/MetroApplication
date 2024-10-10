package com.xworkz.metroApplication.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.metroApplication.entity.UserEntity;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class UserRegisterRepoImpl  implements UserRegisterRepo{
	
	@Autowired
	EntityManagerFactory emf;

	@Override
	public boolean onSaveuser(UserEntity userEntity) {
		log.info("invoking in the onSaveuser method in reopsitoeyimpl..");
      EntityManager em= emf.createEntityManager();
      EntityTransaction et= em.getTransaction();
      try {
		et.begin();
		em.persist(userEntity);
		et.commit();
		return true;
	} catch (Exception e) {
        log.info("getting expection in.. onSaverUser method in repoimpl  "+e.getMessage());
        return false;
	}
      finally {
    	  em.close();
      }
	}

	@Override
	public UserEntity onEmailid(String emailid) {
		
		log.info("invoking in the onEmailid method.."+emailid);
		EntityManager em= emf.createEntityManager();
		EntityTransaction et= em.getTransaction();
		try {
			et.begin();
			Query query= em.createNamedQuery("findUserByEmailid");
			query.setParameter("emid", emailid);
			Object object= query.getSingleResult();
			UserEntity entity=(UserEntity)object;
			log.info("the user is.."+entity);
			et.commit();
			return entity;
			
		} catch (Exception e) {
            log.info("getting expection..."+e.getMessage());
            return null;
		}
		finally {
			em.close();
		}
		
	}

	@Override
	public boolean onUpdate(UserEntity userEntity) {
		EntityManager em= emf.createEntityManager();
		 EntityTransaction et= em.getTransaction();
		 try {
			et.begin();
			em.merge(userEntity);
			et.commit();
			return true;
		} catch (Exception e) {
             log.info("getting expection..."+e.getMessage());
             return false;
		}
		 finally {
			 em.close();
		 }
		
	}

}
