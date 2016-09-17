/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cs.dao;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
    @NamedQuery(name = "GrnLines.findById", query = "SELECT g FROM GrnLines g WHERE g.grnLinesPK.id = :id"),
    @NamedQuery(name = "GrnLines.findByGrn", query = "SELECT g FROM GrnLines g WHERE g.grnLinesPK.grn = :grn"),
    @NamedQuery(name = "GrnLines.findByPcode", query = "SELECT g FROM GrnLines g WHERE g.grnLinesPK.pcode = :pcode"),
    @NamedQuery(name = "GrnLines.findBySerial", query = "SELECT g FROM GrnLines g WHERE g.grnLinesPK.serial = :serial"),
    @NamedQuery(name = "GrnLines.findByQty", query = "SELECT g FROM GrnLines g WHERE g.qty = :qty"),
    @NamedQuery(name = "GrnLines.findByCostPrice", query = "SELECT g FROM GrnLines g WHERE g.costPrice = :costPrice"),
    @NamedQuery(name = "GrnLines.findByActualCostPrice", query = "SELECT g FROM GrnLines g WHERE g.actualCostPrice = :actualCostPrice"),
    @NamedQuery(name = "GrnLines.findByEndUserPrice", query = "SELECT g FROM GrnLines g WHERE g.endUserPrice = :endUserPrice"),
    @NamedQuery(name = "GrnLines.findByDealerPrice", query = "SELECT g FROM GrnLines g WHERE g.dealerPrice = :dealerPrice"),
    @NamedQuery(name = "GrnLines.findByWarrantyInMonths", query = "SELECT g FROM GrnLines g WHERE g.warrantyInMonths = :warrantyInMonths"),
    @NamedQuery(name = "GrnLines.findByWarrantyenddate", query = "SELECT g FROM GrnLines g WHERE g.warrantyenddate = :warrantyenddate"),
    @NamedQuery(name = "GrnLines.findByIsDamage", query = "SELECT g FROM GrnLines g WHERE g.isDamage = :isDamage"),
    @NamedQuery(name = "GrnLines.findByDamageUpdatedUser", query = "SELECT g FROM GrnLines g WHERE g.damageUpdatedUser = :damageUpdatedUser"),
    @NamedQuery(name = "GrnLines.findByDatetime", query = "SELECT g FROM GrnLines g WHERE g.datetime = :datetime"),
    @NamedQuery(name = "GrnLines.findByPrefix", query = "SELECT g FROM GrnLines g WHERE g.prefix = :prefix")})
public class GrnLines implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected GrnLinesPK grnLinesPK;
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
    @Column(name = "warranty_in_months")
    private Integer warrantyInMonths;
    @Column(name = "Warranty_end_date")
    @Temporal(TemporalType.DATE)
    private Date warrantyenddate;
    @Column(name = "isDamage")
    private Boolean isDamage;
    @Column(name = "damage_updated_user")
    private String damageUpdatedUser;
    @Column(name = "datetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datetime;
    @Column(name = "prefix")
    private String prefix;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "grnLines")
    private List<SampleLines> sampleLinesList;
    @JoinColumn(name = "pcode", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Product product;
    @JoinColumn(name = "branch", referencedColumnName = "id")
    @ManyToOne
    private Branch branch;
    @JoinColumn(name = "grn", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Grn grn1;
    @JoinColumn(name = "user", referencedColumnName = "id")
    @ManyToOne
    private Users user;
    @JoinColumn(name = "user_sales", referencedColumnName = "id")
    @ManyToOne
    private Users userSales;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "grnLines")
    private List<BranchTransferLines> branchTransferLinesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "grnLines")
    private List<JobsLines> jobsLinesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "grnLines")
    private List<GrnReturnLines> grnReturnLinesList;
    @OneToMany(mappedBy = "serial")
    private List<ProductBinCard> productBinCardList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "grnLines")
    private List<InvoiceLines> invoiceLinesList;
    @OneToMany(mappedBy = "backupSerial")
    private List<Warrranty> warrrantyList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "grnLines")
    private List<Warrranty> warrrantyList1;

    public GrnLines() {
    }

    public GrnLines(GrnLinesPK grnLinesPK) {
        this.grnLinesPK = grnLinesPK;
    }

    public GrnLines(String id, String grn, String pcode, String serial) {
        this.grnLinesPK = new GrnLinesPK(id, grn, pcode, serial);
    }

    public GrnLinesPK getGrnLinesPK() {
        return grnLinesPK;
    }

    public void setGrnLinesPK(GrnLinesPK grnLinesPK) {
        this.grnLinesPK = grnLinesPK;
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

    public Integer getWarrantyInMonths() {
        return warrantyInMonths;
    }

    public void setWarrantyInMonths(Integer warrantyInMonths) {
        this.warrantyInMonths = warrantyInMonths;
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

    public String getDamageUpdatedUser() {
        return damageUpdatedUser;
    }

    public void setDamageUpdatedUser(String damageUpdatedUser) {
        this.damageUpdatedUser = damageUpdatedUser;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    @XmlTransient
    public List<SampleLines> getSampleLinesList() {
        return sampleLinesList;
    }

    public void setSampleLinesList(List<SampleLines> sampleLinesList) {
        this.sampleLinesList = sampleLinesList;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public Grn getGrn1() {
        return grn1;
    }

    public void setGrn1(Grn grn1) {
        this.grn1 = grn1;
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
        hash += (grnLinesPK != null ? grnLinesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GrnLines)) {
            return false;
        }
        GrnLines other = (GrnLines) object;
        if ((this.grnLinesPK == null && other.grnLinesPK != null) || (this.grnLinesPK != null && !this.grnLinesPK.equals(other.grnLinesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cs.dao.GrnLines[ grnLinesPK=" + grnLinesPK + " ]";
    }
    
}
