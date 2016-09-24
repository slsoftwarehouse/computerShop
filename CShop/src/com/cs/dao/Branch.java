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
@Table(name = "branch")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Branch.findAll", query = "SELECT b FROM Branch b"),
    @NamedQuery(name = "Branch.findById", query = "SELECT b FROM Branch b WHERE b.id = :id"),
    @NamedQuery(name = "Branch.findByName", query = "SELECT b FROM Branch b WHERE b.name = :name"),
    @NamedQuery(name = "Branch.findByDatetime", query = "SELECT b FROM Branch b WHERE b.datetime = :datetime")})
public class Branch implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "datetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datetime;
    @OneToMany(mappedBy = "orgBranch", fetch = FetchType.LAZY)
    private List<SupplierProduct> supplierProductList;
    @OneToMany(mappedBy = "orgBranch", fetch = FetchType.LAZY)
    private List<GrnReturn> grnReturnList;
    @JoinColumn(name = "user", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Users user;
    @OneToMany(mappedBy = "orgBranch", fetch = FetchType.LAZY)
    private List<CreditNote> creditNoteList;
    @OneToMany(mappedBy = "branch", fetch = FetchType.LAZY)
    private List<GrnLines> grnLinesList;
    @OneToMany(mappedBy = "orgBranch", fetch = FetchType.LAZY)
    private List<Grn> grnList;
    @OneToMany(mappedBy = "orgBranch", fetch = FetchType.LAZY)
    private List<Product> productList;
    @OneToMany(mappedBy = "orgBranch", fetch = FetchType.LAZY)
    private List<CashBook> cashBookList;
    @OneToMany(mappedBy = "orgBranch", fetch = FetchType.LAZY)
    private List<Jobs> jobsList;
    @OneToMany(mappedBy = "acceptedBranch", fetch = FetchType.LAZY)
    private List<BranchTransfer> branchTransferList;
    @OneToMany(mappedBy = "transferedBranch", fetch = FetchType.LAZY)
    private List<BranchTransfer> branchTransferList1;
    @OneToMany(mappedBy = "orgBranch", fetch = FetchType.LAZY)
    private List<Sample> sampleList;
    @OneToMany(mappedBy = "orgBranch", fetch = FetchType.LAZY)
    private List<Users> usersList;
    @OneToMany(mappedBy = "orgBranch", fetch = FetchType.LAZY)
    private List<ProductBinCard> productBinCardList;
    @OneToMany(mappedBy = "orgBranch", fetch = FetchType.LAZY)
    private List<Cheques> chequesList;
    @OneToMany(mappedBy = "orgBranch", fetch = FetchType.LAZY)
    private List<Accounts> accountsList;
    @OneToMany(mappedBy = "orgBranch", fetch = FetchType.LAZY)
    private List<Invoice> invoiceList;
    @OneToMany(mappedBy = "orgBranch", fetch = FetchType.LAZY)
    private List<com.cs.dao.Entity> entityList;
    @OneToMany(mappedBy = "orgBranch", fetch = FetchType.LAZY)
    private List<Warrranty> warrrantyList;

    public Branch() {
    }

    public Branch(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    @XmlTransient
    public List<SupplierProduct> getSupplierProductList() {
        return supplierProductList;
    }

    public void setSupplierProductList(List<SupplierProduct> supplierProductList) {
        this.supplierProductList = supplierProductList;
    }

    @XmlTransient
    public List<GrnReturn> getGrnReturnList() {
        return grnReturnList;
    }

    public void setGrnReturnList(List<GrnReturn> grnReturnList) {
        this.grnReturnList = grnReturnList;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    @XmlTransient
    public List<CreditNote> getCreditNoteList() {
        return creditNoteList;
    }

    public void setCreditNoteList(List<CreditNote> creditNoteList) {
        this.creditNoteList = creditNoteList;
    }

    @XmlTransient
    public List<GrnLines> getGrnLinesList() {
        return grnLinesList;
    }

    public void setGrnLinesList(List<GrnLines> grnLinesList) {
        this.grnLinesList = grnLinesList;
    }

    @XmlTransient
    public List<Grn> getGrnList() {
        return grnList;
    }

    public void setGrnList(List<Grn> grnList) {
        this.grnList = grnList;
    }

    @XmlTransient
    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @XmlTransient
    public List<CashBook> getCashBookList() {
        return cashBookList;
    }

    public void setCashBookList(List<CashBook> cashBookList) {
        this.cashBookList = cashBookList;
    }

    @XmlTransient
    public List<Jobs> getJobsList() {
        return jobsList;
    }

    public void setJobsList(List<Jobs> jobsList) {
        this.jobsList = jobsList;
    }

    @XmlTransient
    public List<BranchTransfer> getBranchTransferList() {
        return branchTransferList;
    }

    public void setBranchTransferList(List<BranchTransfer> branchTransferList) {
        this.branchTransferList = branchTransferList;
    }

    @XmlTransient
    public List<BranchTransfer> getBranchTransferList1() {
        return branchTransferList1;
    }

    public void setBranchTransferList1(List<BranchTransfer> branchTransferList1) {
        this.branchTransferList1 = branchTransferList1;
    }

    @XmlTransient
    public List<Sample> getSampleList() {
        return sampleList;
    }

    public void setSampleList(List<Sample> sampleList) {
        this.sampleList = sampleList;
    }

    @XmlTransient
    public List<Users> getUsersList() {
        return usersList;
    }

    public void setUsersList(List<Users> usersList) {
        this.usersList = usersList;
    }

    @XmlTransient
    public List<ProductBinCard> getProductBinCardList() {
        return productBinCardList;
    }

    public void setProductBinCardList(List<ProductBinCard> productBinCardList) {
        this.productBinCardList = productBinCardList;
    }

    @XmlTransient
    public List<Cheques> getChequesList() {
        return chequesList;
    }

    public void setChequesList(List<Cheques> chequesList) {
        this.chequesList = chequesList;
    }

    @XmlTransient
    public List<Accounts> getAccountsList() {
        return accountsList;
    }

    public void setAccountsList(List<Accounts> accountsList) {
        this.accountsList = accountsList;
    }

    @XmlTransient
    public List<Invoice> getInvoiceList() {
        return invoiceList;
    }

    public void setInvoiceList(List<Invoice> invoiceList) {
        this.invoiceList = invoiceList;
    }

    @XmlTransient
    public List<com.cs.dao.Entity> getEntityList() {
        return entityList;
    }

    public void setEntityList(List<com.cs.dao.Entity> entityList) {
        this.entityList = entityList;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Branch)) {
            return false;
        }
        Branch other = (Branch) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cs.dao.Branch[ id=" + id + " ]";
    }
    
}
