package com.xworkz.repository;

import com.xworkz.entity.ReadDataEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;

@Repository
@Slf4j
public class ReadDataRepositoryImplementation implements ReadDataRepository{
    @Autowired
    EntityManagerFactory entityManagerFactory;
    @Override
    public List<ReadDataEntity> readFromDataBase() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try{
            Query query = entityManager.createNamedQuery("hello");
            List<ReadDataEntity> resultList =(List<ReadDataEntity>) query.getResultList();
            log.info(resultList+"result from DataBase");
            return resultList;
        }catch (Exception e){
            log.info("=============");
        }
        finally {
            entityManager.close();
        }
        return null;
    }
}
