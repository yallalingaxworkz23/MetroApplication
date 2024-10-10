package com.xworkz.metroApplication.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.metroApplication.entity.UserLoginEntity;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class UserLoginRepoImpl implements UserLoginRepo{
	
	@Autowired
	EntityManagerFactory emf;

	@Override
	public boolean onSave(UserLoginEntity userLoginEntity) {
		EntityManager em= emf.createEntityManager();
		EntityTransaction et= em.getTransaction();
		try {
			et.begin();
			em.persist(userLoginEntity);
			et.commit();
			return true;
		} catch (Exception e) {
			log.info("getting exception..in onsave mathod.."+e.getMessage());
		return false;
		}
		finally {
			em.close();
		}
		
	}

	@Override
	public UserLoginEntity findByEmailid(String emailid) {
		EntityManager em= emf.createEntityManager();
		EntityTransaction et= em.getTransaction();
		try {
		Query query=em.createNamedQuery("findbyEmailid");
		query.setParameter("em", emailid);
		Object object= query.getSingleResult();
		UserLoginEntity userLoginEntity=(UserLoginEntity)object;
		return userLoginEntity;
		
		} catch (Exception e) {
			log.info("getting exception in findbyemaildid method.."+e.getMessage());
          return null;
		}
		finally {
			em.close();
		}
	}

	@Override
	public boolean onUpdate(UserLoginEntity userLoginEntity) {
		EntityManager em= emf.createEntityManager();
		EntityTransaction et= em.getTransaction();
		
		try {
			et.begin();
			em.merge(userLoginEntity);
			et.commit();
			return true;
			
		} catch (Exception e) {
			log.info("getting exception.. in onupdate.."+e.getMessage());
			return false;
		}
		finally {
			em.close();
		}
	}

}
