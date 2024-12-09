package com.xworkz.repository;

import com.xworkz.entity.UserLoginEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

@Repository
public class UserLoginRepositoryImplementation implements UserLoginRepository{
    @Autowired
     EntityManagerFactory entityManagerFactory;
    @Override
    public String loginByEmail(UserLoginEntity userLoginEntity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            entityManager.merge(userLoginEntity);
            entityTransaction.commit();
        }catch (Exception e){
            System.out.println("print if theres an exception"+e);

        }finally {
            entityManager.close();
        }
        return "data";
    }

}
