package com.brokerage.dao.impl;

import com.brokerage.dao.ContractDAO;
import com.brokerage.model.Contract;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ContractDAOImpl implements ContractDAO{

    final static Logger logger = LoggerFactory.getLogger(ContractDAOImpl.class);

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Contract findById(long id) {
        Contract contract = null;
        try{
            contract = entityManager.createNamedQuery("findById", Contract.class)
                    .setParameter("id", id).getSingleResult();
        }catch (Exception e){
            e.printStackTrace();
            logger.info("No contract record found for id :"+id);
        }
        return contract;
    }

    @Override
    public Boolean existsByPO(String po) {
        Contract contract = null;
        try{
            contract = entityManager.createNamedQuery("findByPO", Contract.class)
                    .setParameter("po", po).getSingleResult();
        }catch (Exception e){
            e.printStackTrace();
            logger.info("No records found for purchase order :"+po);
        }

        if(null != contract){
            return true;
        }
        return false;
    }

    @Override
    public Contract create(Contract contract) {
        entityManager.persist(contract);
        return contract;
    }

    @Override
    public List<Contract> getAll() {
        List<Contract> contracts = new ArrayList<>();
        try{
            contracts = entityManager.createNamedQuery("findAll", Contract.class)
                    .getResultList();
        }catch (Exception e){
            e.printStackTrace();
            logger.info("No contracts found");
        }
        return contracts;
    }
}
