package com.brokerage.service.impl;

import com.brokerage.dao.ContractDAO;
import com.brokerage.model.Contract;
import com.brokerage.model.RoleName;
import com.brokerage.payload.ListRolesResponse;
import com.brokerage.repository.ContractRepository;
import com.brokerage.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@Transactional
public class ContractServiceImpl implements ContractService{

    @Autowired
    private ContractRepository contractRepository;

    @Override
    public Contract findById(long id) {
        return contractRepository.findById(id);
    }

    @Override
    public Boolean existsByPO(String po) {
        return contractRepository.existsByPO(po);
    }

    @Override
    public Contract create(Contract contract) {
        return contractRepository.create(contract);
    }

    @Override
    public ListRolesResponse getRoles() {
        ListRolesResponse listRolesResponse = new ListRolesResponse();
        List<RoleName> list = new ArrayList<>();
        RoleName[] roles = RoleName.values();
        list = Arrays.asList(roles);
        listRolesResponse.setRoles(list);
        return listRolesResponse;
    }
}
