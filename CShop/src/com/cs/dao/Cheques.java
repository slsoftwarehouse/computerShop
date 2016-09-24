/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cs.dao;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author home
 */
@Entity
@Table(name = "cheques")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cheques.findAll", query = "SELECT c FROM Cheques c"),
    @NamedQuery(name = "Cheques.findById", query = "SELECT c FROM Cheques c WHERE c.id = :id"),
    @NamedQuery(name = "Cheques.findByNumber", query = "SELECT c FROM Cheques c WHERE c.number = :number"),
    @NamedQuery(name = "Cheques.findByBankCode", query = "SELECT c FROM Cheques c WHERE c.bankCode = :bankCode"),
    @NamedQuery(name = "Cheques.findByBranchCode", query = "SELECT c FROM Cheques c WHERE c.branchCode = :branchCode"),
    @NamedQuery(name = "Cheques.findByAmount", query = "SELECT c FROM Cheques c WHERE c.amount = :amount"),
    @NamedQuery(name = "Cheques.findByChequeDate", query = "SELECT c FROM Cheques c WHERE c.chequeDate = :chequeDate"),
    @NamedQuery(name = "Cheques.findByChequeStatus", query = "SELECT c FROM Cheques c WHERE c.chequeStatus = :chequeStatus"),
    @NamedQuery(name = "Cheques.findByDepositDate", query = "SELECT c FROM Cheques c WHERE c.depositDate = :depositDate"),
    @NamedQuery(name = "Cheques.findByReturnDate", query = "SELECT c FROM Cheques c WHERE c.returnDate = :returnDate"),
    @NamedQuery(name = "Cheques.findByEntityType", query = "SELECT c FROM Cheques c WHERE c.entityType = :entityType"),
    @NamedQuery(name = "Cheques.findByDescription", query = "SELECT c FROM Cheques c WHERE c.description = :description"),
    @NamedQuery(name = "Cheques.findByDatetime", query = "SELECT c FROM Cheques c WHERE c.datetime = :datetime")})
public class Cheques implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "number")
    private String number;
    @Column(name = "bank_code")
    private String bankCode;
    @Column(name = "branch_code")
    private String branchCode;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "amount")
    private Double amount;
    @Column(name = "cheque_date")
    @Temporal(TemporalType.DATE)
    private Date chequeDate;
    @Column(name = "cheque_status")
    private Integer chequeStatus;
    @Column(name = "deposit_date")
    @Temporal(TemporalType.DATE)
    private Date depositDate;
    @Column(name = "return_date")
    @Temporal(TemporalType.TIME)
    private Date returnDate;
    @Column(name = "entity_type")
    private Integer entityType;
    @Column(name = "description")
    private String description;
    @Column(name = "datetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datetime;
    @JoinColumn(name = "entity", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private com.cs.dao.Entity entity;
    @JoinColumn(name = "org_branch", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Branch orgBranch;
    @JoinColumn(name = "status_code", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private ApplicationConstants statusCode;
    @JoinColumn(name = "user", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Users user;

    public Cheques() {
    }

    public Cheques(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getChequeDate() {
        return chequeDate;
    }

    public void setChequeDate(Date chequeDate) {
        this.chequeDate = chequeDate;
    }

    public Integer getChequeStatus() {
        return chequeStatus;
    }

    public void setChequeStatus(Integer chequeStatus) {
        this.chequeStatus = chequeStatus;
    }

    public Date getDepositDate() {
        return depositDate;
    }

    public void setDepositDate(Date depositDate) {
        this.depositDate = depositDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public Integer getEntityType() {
        return entityType;
    }

    public void setEntityType(Integer entityType) {
        this.entityType = entityType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public com.cs.dao.Entity getEntity() {
        return entity;
    }

    public void setEntity(com.cs.dao.Entity entity) {
        this.entity = entity;
    }

    public Branch getOrgBranch() {
        return orgBranch;
    }

    public void setOrgBranch(Branch orgBranch) {
        this.orgBranch = orgBranch;
    }

    public ApplicationConstants getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(ApplicationConstants statusCode) {
        this.statusCode = statusCode;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
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
        if (!(object instanceof Cheques)) {
            return false;
        }
        Cheques other = (Cheques) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cs.dao.Cheques[ id=" + id + " ]";
    }
    
}
