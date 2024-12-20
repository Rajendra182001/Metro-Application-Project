package com.xworkz.repository;


import com.xworkz.entity.TicketEntity;
import com.xworkz.entity.UserRegistrationEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.swing.tree.ExpandVetoException;
import java.util.List;

@Repository
@Slf4j
public class UserRepositoryImplementation implements  UserRepository {
    @Autowired
    EntityManagerFactory entityManagerFactory;

    @Override
    public String save(UserRegistrationEntity userRegistrationEntity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(userRegistrationEntity);
            transaction.commit();
        } catch (Exception e) {
            log.info("====Print me if theres any exception");
        } finally {
            entityManager.close();
        }
        return "data";
    }

    @Override
    public UserRegistrationEntity findingEmailFromDataBase(String email) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            Query query = entityManager.createNamedQuery("emailFindByMe");
            query.setParameter("email", email);
            Object object = query.getSingleResult();
            UserRegistrationEntity userRegistrationEntity = (UserRegistrationEntity) object;
            log.info("userRegistrationEntity from email {}",userRegistrationEntity);
            return userRegistrationEntity;
        } catch (Exception e) {
            log.info("Some Problem fetching with database");
        } finally {
            entityManager.close();
        }
        return null;
    }

    @Override
    public boolean SaveOtp(String email, String otp) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            Query query = entityManager.createNamedQuery("oneTimeOtp");
            query.setParameter("otp", otp);
            query.setParameter("email", email);
            query.executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            System.out.println("print if theres an error");
        } finally {
            entityManager.close();
        }
        return true;
    }

    @Override
    public UserRegistrationEntity findByUserId(Integer id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            Query query = entityManager.createNamedQuery("findById");
            query.setParameter("id",id);
            UserRegistrationEntity userRegistrationEntity =(UserRegistrationEntity) query.getSingleResult();
            return userRegistrationEntity;
        }catch (Exception e){
            log.info("message {}",e.getMessage());
        }finally {
            entityManager.close();
        }
        return null;
    }

    @Override
    public String saveTheDetails(TicketEntity ticketEntity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(ticketEntity);
            transaction.commit();
        } catch (Exception e) {
            log.info("========");
        } finally {
            entityManager.close();
        }
        return "data";
    }

    @Override
    public List<TicketEntity> getTicketDetails() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            Query query = entityManager.createNamedQuery("readTicket");
            List<TicketEntity> ticketEntityList =(List<TicketEntity>) query.getResultList();
            log.info("ticketEntityList {}",ticketEntityList);
           return ticketEntityList;
        }catch (Exception e){
            log.info("if it is any exceptions",e.getMessage());
        }
        finally {
            entityManager.close();
        }
        return null;
    }

    @Override
    public List<TicketEntity> findingUserIdInTicketHistory(Integer userId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            Query query = entityManager.createNamedQuery("findUserIdTicketHistory");
            query.setParameter("userId",userId);
            List<TicketEntity> ticketEntity =(List<TicketEntity>)  query.getResultList()  ;
            log.info("ticketEntity {}",ticketEntity);
            return ticketEntity;
        } catch (Exception e) {
            log.info("message {}", e.getMessage());
        } finally {
            entityManager.close();
        }
        return null;
       }

    }