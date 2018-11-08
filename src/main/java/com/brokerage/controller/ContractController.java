package com.brokerage.controller;

import com.brokerage.model.Contract;
import com.brokerage.payload.*;
import com.brokerage.service.ContractService;;
import com.brokerage.util.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import javax.validation.Valid;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/contract")
public class ContractController {

    private static final Logger logger = LoggerFactory.getLogger(ContractController.class);

    private static final String DIRECTORY = "/Users/300012961/Projects/spring-boot-jwt-master"+System.getProperty("file.separator")+"PDF";
    private static final String DEFAULT_FILE_NAME = "CE641 _Sep 2018.pdf";

    @Autowired
    private ServletContext servletContext;

    @Autowired
    private UserController UserController;

    @Autowired
    private ContractService contractService;

    @PostMapping("/create")
    @PreAuthorize("hasRole('BROKER')")
    public ResponseEntity<?> registerUser(@Valid @RequestBody CreateContractRequest createContractRequest) {
        if(contractService.existsByPO(createContractRequest.getPoNumber())) {
            return new ResponseEntity(new ApiResponse(false, "Purchase order already exists!"),
                    HttpStatus.BAD_REQUEST);
        }
        java.util.Date dt = new java.util.Date();
        java.text.SimpleDateFormat sdf =
                new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        createContractRequest.setContractDate(dt);

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

    @GetMapping("/getAllContracts")
    public GetAllContractsResponse getAllContracts() {
        GetAllContractsResponse getAllContractsResponse = new GetAllContractsResponse();
        List<Contract> contracts = contractService.getAll();
        getAllContractsResponse.setContractList(contracts);
        return getAllContractsResponse;
    }

    @GetMapping("/getRoles")
    public ListRolesResponse getRoles() {
        return contractService.getRoles();
    }


    /*@RequestMapping(value = "/pdfreports", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> pdfReports() throws IOException {

        List<Contract> contracts = contractService.getAll();

        ByteArrayInputStream bis = GeneratePdfReport.contractReport(contracts);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=contracts.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }*/

    @RequestMapping(value = "/pdfreport", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> pdfReport(@RequestParam(value = "id") long id) throws IOException {

        Contract contract = contractService.findById(id);
        ByteArrayInputStream bis = Client.generatePdf(contract);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=contracts.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }
}
