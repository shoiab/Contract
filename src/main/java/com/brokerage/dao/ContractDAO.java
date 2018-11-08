package com.brokerage.dao;

import com.brokerage.model.Contract;

public interface ContractDAO {

    Contract findById(long id);

    Boolean existsByPO(String po);

    Contract create(Contract contract);
}
