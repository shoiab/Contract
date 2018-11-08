package com.brokerage.controller;

import com.brokerage.model.Contract;
import com.brokerage.payload.ApiResponse;
import com.brokerage.payload.CreateContractRequest;
import com.brokerage.payload.CreateContractResponse;
import com.brokerage.payload.ListRolesResponse;
import com.brokerage.service.ContractService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/contract")
public class ContractController {

    private static final Logger logger = LoggerFactory.getLogger(ContractController.class);

    @Autowired
    private ContractService contractService;

    @PostMapping("/create")
    @PreAuthorize("hasRole('BROKER')")
    public ResponseEntity<?> registerUser(@Valid @RequestBody CreateContractRequest createContractRequest) {
        if(contractService.existsByPO(createContractRequest.getPoNumber())) {
            return new ResponseEntity(new ApiResponse(false, "Purchase order already exists!"),
                    HttpStatus.BAD_REQUEST);
        }

        Contract contract = new Contract(createContractRequest.getPoNumber(),
                createContractRequest.getContractDate(),createContractRequest.getBuyer(),createContractRequest.getSeller(),createContractRequest.getCommodity(),createContractRequest.getRate(),
                createContractRequest.getSpecification(),createContractRequest.getDeliveryTime(),createContractRequest.getLoadingPoint(),createContractRequest.getUnloadingPoint(),
                createContractRequest.getPaymentTerms(),createContractRequest.getUnloadingAddress(),createContractRequest.getCommission());

        Contract contractDb = contractService.create(contract);

        if(null != contractDb){
            return new ResponseEntity(new ApiResponse(true, "Contract created successfully"),
                    HttpStatus.CREATED);
        }
        return new ResponseEntity(new ApiResponse(false, "Contract creation failed"),
                HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/getById")
    public CreateContractResponse getContractById(@RequestParam(value = "id") long id) {
        Contract contract = new Contract();
        contract = contractService.findById(id);
        CreateContractResponse createContractResponse = new CreateContractResponse();
        if(null != contract){
            createContractResponse = new CreateContractResponse(contract.getId(),contract.getPoNumber(),
                    contract.getContractDate(),contract.getBuyer(),contract.getSeller(),contract.getCommodity(),contract.getRate(),
                    contract.getSpecification(),contract.getDeliveryTime(),contract.getLoadingPoint(),contract.getUnloadingPoint(),
                    contract.getPaymentTerms(),contract.getUnloadingAddress(),contract.getCommission());
        }
        return createContractResponse;
    }

    @GetMapping("/getRoles")
    public ListRolesResponse getRoles() {
        return contractService.getRoles();
    }
}
