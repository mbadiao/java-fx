package com.example.gestion_java_fx.repository.impl;

import com.example.gestion_java_fx.entity.Assurance;
import com.example.gestion_java_fx.repository.JPAUtil;
import com.example.gestion_java_fx.repository.ICrud;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class AssuranceRepository implements ICrud<Assurance> {

    @Override
    public ObservableList<Assurance> getAll() {
        EntityManager em = JPAUtil.getEntityManager();
        List<Assurance> list = em.createQuery("SELECT a FROM Assurance a", Assurance.class).getResultList();
        em.close();
        return FXCollections.observableArrayList(list);
    }

    @Override
    public void insert(Assurance assurance) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(assurance);
        tx.commit();
        em.close();
    }

    @Override
    public void delete(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Assurance assurance = em.find(Assurance.class, id);
        if (assurance != null) {
            em.remove(assurance);
        }
        tx.commit();
        em.close();
    }

    @Override
    public Assurance get(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        Assurance assurance = em.find(Assurance.class, id);
        em.close();
        return assurance;
    }

    @Override
    public void update(Assurance assurance) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.merge(assurance);
        tx.commit();
        em.close();
    }
}
