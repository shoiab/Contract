package com.brokerage.payload;

import java.math.BigDecimal;
import java.util.Date;

public class CreateContractResponse {

    public CreateContractResponse() {
    }

    public CreateContractResponse(Long id, String poNumber, Date contractDate, String buyer, String seller, String commodity, BigDecimal rate, String specification, Date deliveryTime, String loadingPoint, String unloadingPoint, String paymentTerms, String unloadingAddress, BigDecimal commission) {
        this.id = id;
        this.poNumber = poNumber;
        this.contractDate = contractDate;
        this.buyer = buyer;
        this.seller = seller;
        this.commodity = commodity;
        this.rate = rate;
        this.specification = specification;
        this.deliveryTime = deliveryTime;
        this.loadingPoint = loadingPoint;
        this.unloadingPoint = unloadingPoint;
        this.paymentTerms = paymentTerms;
        this.unloadingAddress = unloadingAddress;
        this.commission = commission;
    }

    private Long id;

    private String poNumber;

    private Date contractDate;

    private String buyer;

    private String seller;

    private String commodity;

    private BigDecimal rate;

    private String specification;

    private Date deliveryTime;

    private String loadingPoint;

    private String unloadingPoint;

    private String paymentTerms;

    private String unloadingAddress;

    private BigDecimal commission;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPoNumber() {
        return poNumber;
    }

    public void setPoNumber(String poNumber) {
        this.poNumber = poNumber;
    }

    public Date getContractDate() {
        return contractDate;
    }

    public void setContractDate(Date contractDate) {
        this.contractDate = contractDate;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public String getCommodity() {
        return commodity;
    }

    public void setCommodity(String commodity) {
        this.commodity = commodity;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public Date getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Date deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public String getLoadingPoint() {
        return loadingPoint;
    }

    public void setLoadingPoint(String loadingPoint) {
        this.loadingPoint = loadingPoint;
    }

    public String getUnloadingPoint() {
        return unloadingPoint;
    }

    public void setUnloadingPoint(String unloadingPoint) {
        this.unloadingPoint = unloadingPoint;
    }

    public String getPaymentTerms() {
        return paymentTerms;
    }

    public void setPaymentTerms(String paymentTerms) {
        this.paymentTerms = paymentTerms;
    }

    public String getUnloadingAddress() {
        return unloadingAddress;
    }

    public void setUnloadingAddress(String unloadingAddress) {
        this.unloadingAddress = unloadingAddress;
    }

    public BigDecimal getCommission() {
        return commission;
    }

    public void setCommission(BigDecimal commission) {
        this.commission = commission;
    }
}
