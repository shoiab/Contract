package com.brokerage.repository;

import com.brokerage.dao.ContractDAO;
import com.brokerage.model.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Long>, ContractDAO {
}
