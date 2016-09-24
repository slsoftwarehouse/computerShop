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
@Table(name = "users")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u"),
    @NamedQuery(name = "Users.findById", query = "SELECT u FROM Users u WHERE u.id = :id"),
    @NamedQuery(name = "Users.findByName", query = "SELECT u FROM Users u WHERE u.name = :name"),
    @NamedQuery(name = "Users.findByPassword", query = "SELECT u FROM Users u WHERE u.password = :password"),
    @NamedQuery(name = "Users.findByActive", query = "SELECT u FROM Users u WHERE u.active = :active"),
    @NamedQuery(name = "Users.findByRole", query = "SELECT u FROM Users u WHERE u.role = :role"),
    @NamedQuery(name = "Users.findByDatetime", query = "SELECT u FROM Users u WHERE u.datetime = :datetime")})
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "password")
    private String password;
    @Column(name = "active")
    private Boolean active;
    @Column(name = "role")
    private Integer role;
    @Column(name = "datetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datetime;
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<SupplierProduct> supplierProductList;
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Roles> rolesList;
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<GrnReturn> grnReturnList;
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Branch> branchList;
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<CreditNote> creditNoteList;
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<SampleLines> sampleLinesList;
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<GrnLines> grnLinesList;
    @OneToMany(mappedBy = "userSales", fetch = FetchType.LAZY)
    private List<GrnLines> grnLinesList1;
    @OneToMany(mappedBy = "transferedUser", fetch = FetchType.LAZY)
    private List<BranchTransferLines> branchTransferLinesList;
    @OneToMany(mappedBy = "acceptedUser", fetch = FetchType.LAZY)
    private List<BranchTransferLines> branchTransferLinesList1;
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Grn> grnList;
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<JobsLines> jobsLinesList;
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Product> productList;
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<CashBook> cashBookList;
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<GrnReturnLines> grnReturnLinesList;
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Jobs> jobsList;
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<BranchTransfer> branchTransferList;
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Sample> sampleList;
    @JoinColumn(name = "org_branch", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Branch orgBranch;
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<ProductBinCard> productBinCardList;
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Cheques> chequesList;
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Accounts> accountsList;
    @OneToMany(mappedBy = "approvedUser", fetch = FetchType.LAZY)
    private List<Invoice> invoiceList;
    @OneToMany(mappedBy = "recomendedUser", fetch = FetchType.LAZY)
    private List<Invoice> invoiceList1;
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Invoice> invoiceList2;
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<InvoiceLines> invoiceLinesList;
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<com.cs.dao.Entity> entityList;
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Warrranty> warrrantyList;

    public Users() {
    }

    public Users(Integer id) {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
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
    public List<Roles> getRolesList() {
        return rolesList;
    }

    public void setRolesList(List<Roles> rolesList) {
        this.rolesList = rolesList;
    }

    @XmlTransient
    public List<GrnReturn> getGrnReturnList() {
        return grnReturnList;
    }

    public void setGrnReturnList(List<GrnReturn> grnReturnList) {
        this.grnReturnList = grnReturnList;
    }

    @XmlTransient
    public List<Branch> getBranchList() {
        return branchList;
    }

    public void setBranchList(List<Branch> branchList) {
        this.branchList = branchList;
    }

    @XmlTransient
    public List<CreditNote> getCreditNoteList() {
        return creditNoteList;
    }

    public void setCreditNoteList(List<CreditNote> creditNoteList) {
        this.creditNoteList = creditNoteList;
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
    public List<GrnLines> getGrnLinesList1() {
        return grnLinesList1;
    }

    public void setGrnLinesList1(List<GrnLines> grnLinesList1) {
        this.grnLinesList1 = grnLinesList1;
    }

    @XmlTransient
    public List<BranchTransferLines> getBranchTransferLinesList() {
        return branchTransferLinesList;
    }

    public void setBranchTransferLinesList(List<BranchTransferLines> branchTransferLinesList) {
        this.branchTransferLinesList = branchTransferLinesList;
    }

    @XmlTransient
    public List<BranchTransferLines> getBranchTransferLinesList1() {
        return branchTransferLinesList1;
    }

    public void setBranchTransferLinesList1(List<BranchTransferLines> branchTransferLinesList1) {
        this.branchTransferLinesList1 = branchTransferLinesList1;
    }

    @XmlTransient
    public List<Grn> getGrnList() {
        return grnList;
    }

    public void setGrnList(List<Grn> grnList) {
        this.grnList = grnList;
    }

    @XmlTransient
    public List<JobsLines> getJobsLinesList() {
        return jobsLinesList;
    }

    public void setJobsLinesList(List<JobsLines> jobsLinesList) {
        this.jobsLinesList = jobsLinesList;
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
    public List<GrnReturnLines> getGrnReturnLinesList() {
        return grnReturnLinesList;
    }

    public void setGrnReturnLinesList(List<GrnReturnLines> grnReturnLinesList) {
        this.grnReturnLinesList = grnReturnLinesList;
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
    public List<Sample> getSampleList() {
        return sampleList;
    }

    public void setSampleList(List<Sample> sampleList) {
        this.sampleList = sampleList;
    }

    public Branch getOrgBranch() {
        return orgBranch;
    }

    public void setOrgBranch(Branch orgBranch) {
        this.orgBranch = orgBranch;
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
    public List<Invoice> getInvoiceList1() {
        return invoiceList1;
    }

    public void setInvoiceList1(List<Invoice> invoiceList1) {
        this.invoiceList1 = invoiceList1;
    }

    @XmlTransient
    public List<Invoice> getInvoiceList2() {
        return invoiceList2;
    }

    public void setInvoiceList2(List<Invoice> invoiceList2) {
        this.invoiceList2 = invoiceList2;
    }

    @XmlTransient
    public List<InvoiceLines> getInvoiceLinesList() {
        return invoiceLinesList;
    }

    public void setInvoiceLinesList(List<InvoiceLines> invoiceLinesList) {
        this.invoiceLinesList = invoiceLinesList;
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
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cs.dao.Users[ id=" + id + " ]";
    }
    
}
