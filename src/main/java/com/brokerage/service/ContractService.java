package com.brokerage.service;

import com.brokerage.model.Contract;
import com.brokerage.payload.ListRolesResponse;

import java.util.List;

public interface ContractService {

    Contract findById(long id);

    Boolean existsByPO(String po);

    Contract create(Contract contract);

    ListRolesResponse getRoles();

    List<Contract> getAll();
}
