package com.xworkz.repository;

import com.xworkz.entity.LoginEntity;

import com.xworkz.entity.RegistrationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;


@Repository
public class MetroRepositoryImpl implements MetroRepository{

    @Autowired
    EntityManagerFactory entityManagerFactory;
    @Override
    public String save(RegistrationEntity registrationEntity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
         entityTransaction.begin();
         entityManager.persist(registrationEntity);
         entityTransaction.commit();

        }catch (Exception e){
            System.out.println("print if theres an exception"+e);
        }finally {
            entityManager.close();
        }
        return "data";
    }

    @Override
    public List<RegistrationEntity> readUser() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
        Query query = entityManager.createNamedQuery("read");
            List<RegistrationEntity> resultList = (List<RegistrationEntity>) query.getResultList();
            System.out.println(resultList);
            return resultList;
        }catch (Exception e){
            throw new RuntimeException();
        }
        finally {
            entityManager.close();
        }
    }

    @Override
    public RegistrationEntity findByUserName(String userName) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            Query query = entityManager.createNamedQuery("findByUserName");
            query.setParameter("name", userName);
            Object object = query.getSingleResult();
            RegistrationEntity registrationEntity = (RegistrationEntity) object;
            return registrationEntity;
        } catch (Exception e) {
            System.err.println("hiii");
            return null;
        } finally {
            entityManager.close();
        }

    }

    @Override
    public String onLoginSave(LoginEntity loginEntity) {
        System.out.println(loginEntity);
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            entityManager.merge(loginEntity);
            entityTransaction.commit();
        }catch (Exception e){
            System.out.println("print if theres an exception"+e);

        }finally {
            entityManager.close();
        }
        return "data";
    }

    @Override
    public RegistrationEntity findByEmail(String email) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            Query query = entityManager.createNamedQuery("findByEmail");
            query.setParameter("email", email);
            Object object = query.getSingleResult();;
            RegistrationEntity registrationEntity = (RegistrationEntity) object;
            System.out.println(registrationEntity);
            return registrationEntity;
        } catch (Exception e) {
            System.err.println("got some error while fetching email dto");
            return null;
        } finally {
            entityManager.close();
        }
    }

    @Override
    public String loginByEmail(LoginEntity loginEntity) {
        System.out.println(loginEntity);
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
try {
    entityTransaction.begin();
    entityManager.merge(loginEntity);
    entityTransaction.commit();
}catch (Exception e){
    System.out.println("print if theres an exception"+e);
}finally {
     entityManager.close();
}
        return "data";
    }


    @Override
   public RegistrationEntity saveOtp(String email,String otp) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            Query query = entityManager.createNamedQuery("updateEmail");
            query.setParameter("otp", otp);
            query.setParameter("email", email);
            query.executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            System.out.println("print if theres an error");
        } finally {
            entityManager.close();
            return null;

        }
    }

    @Override
    public String updatePassword(String email, String password) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
           transaction.begin();
            Query query = entityManager.createNamedQuery("updatePassword");
            query.setParameter("password",password);
            query.setParameter("email", email);
            query.executeUpdate();
            transaction.commit();
        }catch (Exception e){
           System.out.println("error");
        }
       finally {
           entityManager.close();
       }
        return "";
    }

    @Override

    public void userLocked(String email, int noOfAttempts, boolean isAccountLocked) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try{
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            Query query = entityManager.createNamedQuery("wrongAttempt");
            query.setParameter("email",email);
            query.setParameter("noOfAttempts",noOfAttempts);
            query.setParameter("isAccountLocked",isAccountLocked);
            query.executeUpdate();
            transaction.commit();
            System.out.println("em========================"+noOfAttempts);
            System.out.println("em========================"+email);
            System.out.println("em========================"+isAccountLocked);

        }catch (Exception e){
            System.out.println("error");
        }finally {
          entityManager.close();
        }
    }

    @Override
    public String updateUser(RegistrationEntity registrationEntity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try{
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
             entityManager.merge(registrationEntity);
            transaction.commit();
        }catch(Exception e){
            System.out.println("print if theres error");
        }finally {
            entityManager.close();
        }
        return null;
    }
}
