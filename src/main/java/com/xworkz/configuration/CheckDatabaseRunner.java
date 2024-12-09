package com.xworkz.configuration;

import com.xworkz.entity.AddTrainEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class CheckDatabaseRunner {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("Hello");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query getAllDetailsById = entityManager.createNamedQuery("getAllDetailsById");
        AddTrainEntity trainId = (AddTrainEntity) getAllDetailsById.setParameter("trainId", 1).getSingleResult();
        System.out.println(trainId);


    }
}
