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
@Table(name = "product")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p"),
    @NamedQuery(name = "Product.findById", query = "SELECT p FROM Product p WHERE p.productPK.id = :id"),
    @NamedQuery(name = "Product.findByName", query = "SELECT p FROM Product p WHERE p.productPK.name = :name"),
    @NamedQuery(name = "Product.findByOrgBranch", query = "SELECT p FROM Product p WHERE p.productPK.orgBranch = :orgBranch"),
    @NamedQuery(name = "Product.findByManagePriceGlobaly", query = "SELECT p FROM Product p WHERE p.managePriceGlobaly = :managePriceGlobaly"),
    @NamedQuery(name = "Product.findByGlobalDealerPrice", query = "SELECT p FROM Product p WHERE p.globalDealerPrice = :globalDealerPrice"),
    @NamedQuery(name = "Product.findByGlobalEnduserPrice", query = "SELECT p FROM Product p WHERE p.globalEnduserPrice = :globalEnduserPrice"),
    @NamedQuery(name = "Product.findByGlobslCostPrice", query = "SELECT p FROM Product p WHERE p.globslCostPrice = :globslCostPrice"),
    @NamedQuery(name = "Product.findByGlobalActualCostPrice", query = "SELECT p FROM Product p WHERE p.globalActualCostPrice = :globalActualCostPrice"),
    @NamedQuery(name = "Product.findByQih", query = "SELECT p FROM Product p WHERE p.qih = :qih"),
    @NamedQuery(name = "Product.findByDqih", query = "SELECT p FROM Product p WHERE p.dqih = :dqih"),
    @NamedQuery(name = "Product.findByDatetime", query = "SELECT p FROM Product p WHERE p.datetime = :datetime"),
    @NamedQuery(name = "Product.findByPrefix", query = "SELECT p FROM Product p WHERE p.prefix = :prefix")})
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProductPK productPK;
    @Column(name = "manage_price_globaly")
    private Boolean managePriceGlobaly;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "global_dealer_price")
    private Double globalDealerPrice;
    @Column(name = "global_enduser_price")
    private Double globalEnduserPrice;
    @Column(name = "globsl_cost_price")
    private Double globslCostPrice;
    @Column(name = "global_actual_cost_price")
    private Double globalActualCostPrice;
    @Column(name = "qih")
    private Integer qih;
    @Column(name = "dqih")
    private Integer dqih;
    @Column(name = "datetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datetime;
    @Column(name = "prefix")
    private String prefix;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product1")
    private List<SupplierProduct> supplierProductList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product1")
    private List<SampleLines> sampleLinesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    private List<GrnLines> grnLinesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    private List<BranchTransferLines> branchTransferLinesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product1")
    private List<JobsLines> jobsLinesList;
    @JoinColumn(name = "org_branch", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Branch branch;
    @JoinColumn(name = "user", referencedColumnName = "id")
    @ManyToOne
    private Users user;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product1")
    private List<GrnReturnLines> grnReturnLinesList;
    @OneToMany(mappedBy = "product")
    private List<ProductBinCard> productBinCardList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product1")
    private List<InvoiceLines> invoiceLinesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product1")
    private List<Warrranty> warrrantyList;

    public Product() {
    }

    public Product(ProductPK productPK) {
        this.productPK = productPK;
    }

    public Product(String id, String name, int orgBranch) {
        this.productPK = new ProductPK(id, name, orgBranch);
    }

    public ProductPK getProductPK() {
        return productPK;
    }

    public void setProductPK(ProductPK productPK) {
        this.productPK = productPK;
    }

    public Boolean getManagePriceGlobaly() {
        return managePriceGlobaly;
    }

    public void setManagePriceGlobaly(Boolean managePriceGlobaly) {
        this.managePriceGlobaly = managePriceGlobaly;
    }

    public Double getGlobalDealerPrice() {
        return globalDealerPrice;
    }

    public void setGlobalDealerPrice(Double globalDealerPrice) {
        this.globalDealerPrice = globalDealerPrice;
    }

    public Double getGlobalEnduserPrice() {
        return globalEnduserPrice;
    }

    public void setGlobalEnduserPrice(Double globalEnduserPrice) {
        this.globalEnduserPrice = globalEnduserPrice;
    }

    public Double getGlobslCostPrice() {
        return globslCostPrice;
    }

    public void setGlobslCostPrice(Double globslCostPrice) {
        this.globslCostPrice = globslCostPrice;
    }

    public Double getGlobalActualCostPrice() {
        return globalActualCostPrice;
    }

    public void setGlobalActualCostPrice(Double globalActualCostPrice) {
        this.globalActualCostPrice = globalActualCostPrice;
    }

    public Integer getQih() {
        return qih;
    }

    public void setQih(Integer qih) {
        this.qih = qih;
    }

    public Integer getDqih() {
        return dqih;
    }

    public void setDqih(Integer dqih) {
        this.dqih = dqih;
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
    public List<SupplierProduct> getSupplierProductList() {
        return supplierProductList;
    }

    public void setSupplierProductList(List<SupplierProduct> supplierProductList) {
        this.supplierProductList = supplierProductList;
    }

    @XmlTransient
    public List<SampleLines> getSampleLinesList() {
        return sampleLinesList;
    }

    public void setSampleLinesList(List<SampleLines> sampleLinesList) {
        this.sampleLinesList = sampleLinesList;
    }

    @XmlTransient
    public List<GrnLines> getGrnLinesList() {
        return grnLinesList;
    }

    public void setGrnLinesList(List<GrnLines> grnLinesList) {
        this.grnLinesList = grnLinesList;
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

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productPK != null ? productPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.productPK == null && other.productPK != null) || (this.productPK != null && !this.productPK.equals(other.productPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cs.dao.Product[ productPK=" + productPK + " ]";
    }
    
}
