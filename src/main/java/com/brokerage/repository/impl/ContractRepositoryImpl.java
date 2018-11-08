package com.brokerage.repository.impl;

import com.brokerage.dao.ContractDAO;
import com.brokerage.dao.impl.ContractDAOImpl;
import com.brokerage.model.Contract;
import com.brokerage.service.ContractService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.TypedQuery;

//@Repository
public class ContractRepositoryImpl {

    /*final static Logger logger = LoggerFactory.getLogger(ContractRepositoryImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Contract findById(long id) {
        Session session = null;
        session = sessionFactory.openSession();
        session.beginTransaction();
        TypedQuery<Contract> query = session.getNamedQuery("findById");
        query.setParameter("id", id);
        Contract contract = query.getSingleResult();
        session.getTransaction().commit();
        return contract;
    }

    @Override
    public Boolean existsByPO(String po) {
        Session session = null;
        session = sessionFactory.openSession();
        session.beginTransaction();
        TypedQuery<Contract> query = session.getNamedQuery("findByPO");
        query.setParameter("po", po);
        Contract contract = query.getSingleResult();
        session.getTransaction().commit();
        if(null != contract){
            return true;
        }
        return false;
    }

    @Override
    public Contract create(Contract contract) {
        Session session = null;
        session = sessionFactory.openSession();
        session.beginTransaction();
        Long id = (Long) session.save(contract);
        contract.setId(id);
        session.getTransaction().commit();
        return contract;
    }*/
}
