package com.xworkz.repository;

import com.xworkz.entity.AddTrainEntity;
import com.xworkz.entity.LocationEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Repository
@Slf4j
public class AddTrainRepositoryImplementation implements AddTrainRepository {

    @Autowired
    EntityManagerFactory entityManagerFactory;

    @Override
    public String saveTrainTypeAndNumber(AddTrainEntity addTrainEntity) {
        log.info("add train entity is ====================  " + addTrainEntity);
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(addTrainEntity);
            transaction.commit();
        } catch (Exception e) {
            log.info("=========================");
        } finally {
            entityManager.close();
        }
        return "";
    }

    @Override
    public AddTrainEntity findByTrainNumberAndTrainType(String trainNumber, String trainType) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            Query query = entityManager.createNamedQuery("findByTrainNumberAndTrainType");
            query.setParameter("trainNumber", trainNumber);
            query.setParameter("trainType", trainType);
            Object object = query.getSingleResult();
            AddTrainEntity addTrainEntity = (AddTrainEntity) object;
            log.info(addTrainEntity + "addTrainee entity========================");
            return addTrainEntity;
        } catch (Exception e) {
            log.info("=======================================");
        } finally {
            entityManager.close();
        }
        return null;
    }

    @Override
    public List<AddTrainEntity> readAddTrainDetails() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            Query query = entityManager.createNamedQuery("readTrain");
            List<AddTrainEntity> resultList = (List<AddTrainEntity>) query.getResultList();
            //Optional<List<AddTrainEntity>> resultList1 = Optional.of(resultList);
            log.info("resultlist {}",resultList);
            return resultList;
        } catch (Exception e) {
            log.info("==============================");
        } finally {
            entityManager.close();
        }
        return null;
    }


    @Override
    public AddTrainEntity findById(Integer addTrainId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            Query query = entityManager.createNamedQuery("getAllDetailsById");
            query.setParameter("trainId",addTrainId);
            log.info("addTrainId",addTrainId);
            System.out.println("Trainee Id is"+ addTrainId);
            AddTrainEntity addTrainEntities =(AddTrainEntity) query.getSingleResult();
            System.out.println("addTrainEntities from :"+addTrainEntities);
            return addTrainEntities;
        }catch (Exception e){
            log.info("============"+addTrainId);
            return null;
        }finally {
            entityManager.close();
        }
    }

    @Override
    public AddTrainEntity findByTrainType(String trainType) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try{
            Query query = entityManager.createNamedQuery("findAddTrainType");
            query.setParameter("trainType",trainType);
            Object object = query.getSingleResult();
            AddTrainEntity addTrainEntity = (AddTrainEntity) object;
            return addTrainEntity;
        }catch (Exception e){
            log.error("================findBYTRAINTYPE"+trainType);
        }finally {
            entityManager.close();
        }
        return null;
    }

    @Override
    public AddTrainEntity findTrainNumber(String trainNumber) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try{
            Query query = entityManager.createNamedQuery("findNumber");
            query.setParameter("number",trainNumber);
            Object object = query.getSingleResult();
            AddTrainEntity addTrainEntity = (AddTrainEntity) object;
            return addTrainEntity;
        }catch (Exception e){
            log.info("find by train Number is :"+trainNumber);
        }finally {
            entityManager.close();
        }
        return null;
    }


}