package com.brokerage.payload;

import com.brokerage.model.Contract;

import java.util.ArrayList;
import java.util.List;

public class GetAllContractsResponse {

    List<Contract> contractList = new ArrayList<>();

    public List<Contract> getContractList() {
        return contractList;
    }

    public void setContractList(List<Contract> contractList) {
        this.contractList = contractList;
    }
}
