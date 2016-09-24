/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cs.dao;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author home
 */
@Entity
@Table(name = "grn_lines")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GrnLines.findAll", query = "SELECT g FROM GrnLines g"),
    @NamedQuery(name = "GrnLines.findById", query = "SELECT g FROM GrnLines g WHERE g.id = :id"),
    @NamedQuery(name = "GrnLines.findBySerial", query = "SELECT g FROM GrnLines g WHERE g.serial = :serial"),
    @NamedQuery(name = "GrnLines.findByQty", query = "SELECT g FROM GrnLines g WHERE g.qty = :qty"),
    @NamedQuery(name = "GrnLines.findByCostPrice", query = "SELECT g FROM GrnLines g WHERE g.costPrice = :costPrice"),
    @NamedQuery(name = "GrnLines.findByActualCostPrice", query = "SELECT g FROM GrnLines g WHERE g.actualCostPrice = :actualCostPrice"),
    @NamedQuery(name = "GrnLines.findByEndUserPrice", query = "SELECT g FROM GrnLines g WHERE g.endUserPrice = :endUserPrice"),
    @NamedQuery(name = "GrnLines.findByDealerPrice", query = "SELECT g FROM GrnLines g WHERE g.dealerPrice = :dealerPrice"),
    @NamedQuery(name = "GrnLines.findByWarrantyInDays", query = "SELECT g FROM GrnLines g WHERE g.warrantyInDays = :warrantyInDays"),
    @NamedQuery(name = "GrnLines.findByWarrantyenddate", query = "SELECT g FROM GrnLines g WHERE g.warrantyenddate = :warrantyenddate"),
    @NamedQuery(name = "GrnLines.findByIsDamage", query = "SELECT g FROM GrnLines g WHERE g.isDamage = :isDamage"),
    @NamedQuery(name = "GrnLines.findByDamageUpdatedUser", query = "SELECT g FROM GrnLines g WHERE g.damageUpdatedUser = :damageUpdatedUser"),
    @NamedQuery(name = "GrnLines.findByDatetime", query = "SELECT g FROM GrnLines g WHERE g.datetime = :datetime")})
public class GrnLines implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "serial")
    private String serial;
    @Column(name = "qty")
    private Integer qty;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cost_price")
    private Double costPrice;
    @Column(name = "actual_cost_price")
    private Double actualCostPrice;
    @Column(name = "end_user_price")
    private Double endUserPrice;
    @Column(name = "dealer_price")
    private Double dealerPrice;
    @Column(name = "warranty_in_days")
    private Integer warrantyInDays;
    @Column(name = "Warranty_end_date")
    @Temporal(TemporalType.DATE)
    private Date warrantyenddate;
    @Column(name = "isDamage")
    private Boolean isDamage;
    @Column(name = "damage_updated_user")
    private Integer damageUpdatedUser;
    @Column(name = "datetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datetime;
    @OneToMany(mappedBy = "serial", fetch = FetchType.LAZY)
    private List<SampleLines> sampleLinesList;
    @JoinColumn(name = "pcode", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Product pcode;
    @JoinColumn(name = "branch", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Branch branch;
    @JoinColumn(name = "grn", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Grn grn;
    @JoinColumn(name = "user", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Users user;
    @JoinColumn(name = "user_sales", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Users userSales;
    @OneToMany(mappedBy = "serial", fetch = FetchType.LAZY)
    private List<BranchTransferLines> branchTransferLinesList;
    @OneToMany(mappedBy = "serial", fetch = FetchType.LAZY)
    private List<JobsLines> jobsLinesList;
    @OneToMany(mappedBy = "serial", fetch = FetchType.LAZY)
    private List<GrnReturnLines> grnReturnLinesList;
    @OneToMany(mappedBy = "serial", fetch = FetchType.LAZY)
    private List<ProductBinCard> productBinCardList;
    @OneToMany(mappedBy = "serial", fetch = FetchType.LAZY)
    private List<InvoiceLines> invoiceLinesList;
    @OneToMany(mappedBy = "backupSerial", fetch = FetchType.LAZY)
    private List<Warrranty> warrrantyList;
    @OneToMany(mappedBy = "serial", fetch = FetchType.LAZY)
    private List<Warrranty> warrrantyList1;

    public GrnLines() {
    }

    public GrnLines(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Double getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(Double costPrice) {
        this.costPrice = costPrice;
    }

    public Double getActualCostPrice() {
        return actualCostPrice;
    }

    public void setActualCostPrice(Double actualCostPrice) {
        this.actualCostPrice = actualCostPrice;
    }

    public Double getEndUserPrice() {
        return endUserPrice;
    }

    public void setEndUserPrice(Double endUserPrice) {
        this.endUserPrice = endUserPrice;
    }

    public Double getDealerPrice() {
        return dealerPrice;
    }

    public void setDealerPrice(Double dealerPrice) {
        this.dealerPrice = dealerPrice;
    }

    public Integer getWarrantyInDays() {
        return warrantyInDays;
    }

    public void setWarrantyInDays(Integer warrantyInDays) {
        this.warrantyInDays = warrantyInDays;
    }

    public Date getWarrantyenddate() {
        return warrantyenddate;
    }

    public void setWarrantyenddate(Date warrantyenddate) {
        this.warrantyenddate = warrantyenddate;
    }

    public Boolean getIsDamage() {
        return isDamage;
    }

    public void setIsDamage(Boolean isDamage) {
        this.isDamage = isDamage;
    }

    public Integer getDamageUpdatedUser() {
        return damageUpdatedUser;
    }

    public void setDamageUpdatedUser(Integer damageUpdatedUser) {
        this.damageUpdatedUser = damageUpdatedUser;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    @XmlTransient
    public List<SampleLines> getSampleLinesList() {
        return sampleLinesList;
    }

    public void setSampleLinesList(List<SampleLines> sampleLinesList) {
        this.sampleLinesList = sampleLinesList;
    }

    public Product getPcode() {
        return pcode;
    }

    public void setPcode(Product pcode) {
        this.pcode = pcode;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public Grn getGrn() {
        return grn;
    }

    public void setGrn(Grn grn) {
        this.grn = grn;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Users getUserSales() {
        return userSales;
    }

    public void setUserSales(Users userSales) {
        this.userSales = userSales;
    }

    @XmlTransient
    public List<BranchTransferLines> getBranchTransferLinesList() {
        return branchTransferLinesList;
    }

    public void setBranchTransferLinesList(List<BranchTransferLines> branchTransferLinesList) {
        this.branchTransferLinesList = branchTransferLinesList;
    }

    @XmlTransient
    public List<JobsLines> getJobsLinesList() {
        return jobsLinesList;
    }

    public void setJobsLinesList(List<JobsLines> jobsLinesList) {
        this.jobsLinesList = jobsLinesList;
    }

    @XmlTransient
    public List<GrnReturnLines> getGrnReturnLinesList() {
        return grnReturnLinesList;
    }

    public void setGrnReturnLinesList(List<GrnReturnLines> grnReturnLinesList) {
        this.grnReturnLinesList = grnReturnLinesList;
    }

    @XmlTransient
    public List<ProductBinCard> getProductBinCardList() {
        return productBinCardList;
    }

    public void setProductBinCardList(List<ProductBinCard> productBinCardList) {
        this.productBinCardList = productBinCardList;
    }

    @XmlTransient
    public List<InvoiceLines> getInvoiceLinesList() {
        return invoiceLinesList;
    }

    public void setInvoiceLinesList(List<InvoiceLines> invoiceLinesList) {
        this.invoiceLinesList = invoiceLinesList;
    }

    @XmlTransient
    public List<Warrranty> getWarrrantyList() {
        return warrrantyList;
    }

    public void setWarrrantyList(List<Warrranty> warrrantyList) {
        this.warrrantyList = warrrantyList;
    }

    @XmlTransient
    public List<Warrranty> getWarrrantyList1() {
        return warrrantyList1;
    }

    public void setWarrrantyList1(List<Warrranty> warrrantyList1) {
        this.warrrantyList1 = warrrantyList1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GrnLines)) {
            return false;
        }
        GrnLines other = (GrnLines) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cs.dao.GrnLines[ id=" + id + " ]";
    }
    
}
