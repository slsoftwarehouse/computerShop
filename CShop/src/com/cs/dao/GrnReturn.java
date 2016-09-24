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
@Table(name = "grn_return")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GrnReturn.findAll", query = "SELECT g FROM GrnReturn g"),
    @NamedQuery(name = "GrnReturn.findById", query = "SELECT g FROM GrnReturn g WHERE g.id = :id"),
    @NamedQuery(name = "GrnReturn.findByReturnTotal", query = "SELECT g FROM GrnReturn g WHERE g.returnTotal = :returnTotal"),
    @NamedQuery(name = "GrnReturn.findByDatetime", query = "SELECT g FROM GrnReturn g WHERE g.datetime = :datetime")})
public class GrnReturn implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "return_total")
    private Double returnTotal;
    @Column(name = "datetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datetime;
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
    @OneToMany(mappedBy = "return1", fetch = FetchType.LAZY)
    private List<GrnReturnLines> grnReturnLinesList;

    public GrnReturn() {
    }

    public GrnReturn(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getReturnTotal() {
        return returnTotal;
    }

    public void setReturnTotal(Double returnTotal) {
        this.returnTotal = returnTotal;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
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

    @XmlTransient
    public List<GrnReturnLines> getGrnReturnLinesList() {
        return grnReturnLinesList;
    }

    public void setGrnReturnLinesList(List<GrnReturnLines> grnReturnLinesList) {
        this.grnReturnLinesList = grnReturnLinesList;
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
        if (!(object instanceof GrnReturn)) {
            return false;
        }
        GrnReturn other = (GrnReturn) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cs.dao.GrnReturn[ id=" + id + " ]";
    }
    
}
