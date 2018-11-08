package com.brokerage.dao;

import com.brokerage.model.Contract;

import java.util.List;

public interface ContractDAO {

    Contract findById(long id);

    Boolean existsByPO(String po);

    Contract create(Contract contract);

    List<Contract> getAll();
}
