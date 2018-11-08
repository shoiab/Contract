package com.brokerage.model;

import com.brokerage.model.audit.DateAudit;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by shoiab khan on 08/11/18.
 */
@Entity
@Table(name = "contract")
@NamedQueries({
        @NamedQuery(
                name = "findById",
                query = "from Contract c where c.id = :id"
        ),
        @NamedQuery(
                name = "findByPO",
                query = "from Contract c where c.poNumber = :po"
        ),
        @NamedQuery(
                name = "findAll",
                query = "from Contract c ORDER BY c.contractDate DESC"
        )
})
public class Contract extends DateAudit {

    public Contract() {
    }

    public Contract(@NotBlank @Size(max = 250) String poNumber, @NotBlank Date contractDate, @NotBlank @Size(max = 500) String buyer, @NotBlank @Size(max = 500) String seller, @NotBlank @Size(max = 40) String commodity, @NotBlank BigDecimal rate, @NotBlank @Size(max = 250) String specification, @NotBlank Date deliveryTime, @NotBlank @Size(max = 250) String loadingPoint, @NotBlank @Size(max = 250) String unloadingPoint, @NotBlank @Size(max = 250) String paymentTerms, @NotBlank @Size(max = 250) String unloadingAddress, @NotBlank BigDecimal commission) {
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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 250)
    @Column(name="po_number")
    private String poNumber;

    @NotNull
    @Column(name="contract_date")
    private Date contractDate;

    @NotBlank
    @Size(max = 500)
    @Column(name="buyer")
    private String buyer;

    @NotBlank
    @Size(max = 500)
    @Column(name="seller")
    private String seller;

    @NotBlank
    @Size(max = 40)
    @Column(name="commodity")
    private String commodity;

    @NotNull
    @Column(name="rate")
    private BigDecimal rate;

    @NotBlank
    @Size(max = 250)
    @Column(name="specification")
    private String specification;

    @NotNull
    @Column(name="delivery_time")
    private Date deliveryTime;

    @NotBlank
    @Size(max = 250)
    @Column(name="loading_point")
    private String loadingPoint;

    @NotBlank
    @Size(max = 250)
    @Column(name="unloading_point")
    private String unloadingPoint;

    @NotBlank
    @Size(max = 250)
    @Column(name="payment_terms")
    private String paymentTerms;

    @NotBlank
    @Size(max = 250)
    @Column(name="unloading_address")
    private String unloadingAddress;

    @NotNull
    @Column(name="commission")
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
