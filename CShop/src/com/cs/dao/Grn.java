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
@Table(name = "grn")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Grn.findAll", query = "SELECT g FROM Grn g"),
    @NamedQuery(name = "Grn.findById", query = "SELECT g FROM Grn g WHERE g.id = :id"),
    @NamedQuery(name = "Grn.findByTotal", query = "SELECT g FROM Grn g WHERE g.total = :total"),
    @NamedQuery(name = "Grn.findByDisscountTotal", query = "SELECT g FROM Grn g WHERE g.disscountTotal = :disscountTotal"),
    @NamedQuery(name = "Grn.findByDatetime", query = "SELECT g FROM Grn g WHERE g.datetime = :datetime"),
    @NamedQuery(name = "Grn.findByPrefix", query = "SELECT g FROM Grn g WHERE g.prefix = :prefix")})
public class Grn implements Serializable {

    @JoinColumn(name = "payment_method", referencedColumnName = "id")
    @ManyToOne
    private ApplicationConstants paymentMethod;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private String id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "total")
    private Double total;
    @Column(name = "disscount_total")
    private Double disscountTotal;
    @Column(name = "datetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datetime;
    @Column(name = "prefix")
    private String prefix;
    @OneToMany(mappedBy = "grn", fetch = FetchType.LAZY)
    private List<GrnLines> grnLinesList;
    @JoinColumn(name = "org_branch", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Branch orgBranch;
    @JoinColumn(name = "credit_note", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private CreditNote creditNote;
    @JoinColumn(name = "supplier", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private com.cs.dao.Entity supplier;
    @JoinColumn(name = "user", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Users user;

    public Grn() {
    }

    public Grn(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getDisscountTotal() {
        return disscountTotal;
    }

    public void setDisscountTotal(Double disscountTotal) {
        this.disscountTotal = disscountTotal;
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
    public List<GrnLines> getGrnLinesList() {
        return grnLinesList;
    }

    public void setGrnLinesList(List<GrnLines> grnLinesList) {
        this.grnLinesList = grnLinesList;
    }

    public Branch getOrgBranch() {
        return orgBranch;
    }

    public void setOrgBranch(Branch orgBranch) {
        this.orgBranch = orgBranch;
    }

    public CreditNote getCreditNote() {
        return creditNote;
    }

    public void setCreditNote(CreditNote creditNote) {
        this.creditNote = creditNote;
    }

    public com.cs.dao.Entity getSupplier() {
        return supplier;
    }

    public void setSupplier(com.cs.dao.Entity supplier) {
        this.supplier = supplier;
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
        if (!(object instanceof Grn)) {
            return false;
        }
        Grn other = (Grn) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cs.dao.Grn[ id=" + id + " ]";
    }

    public ApplicationConstants getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(ApplicationConstants paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
    
}
