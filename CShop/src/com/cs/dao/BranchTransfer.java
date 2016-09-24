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
@Table(name = "branch_transfer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BranchTransfer.findAll", query = "SELECT b FROM BranchTransfer b"),
    @NamedQuery(name = "BranchTransfer.findById", query = "SELECT b FROM BranchTransfer b WHERE b.id = :id"),
    @NamedQuery(name = "BranchTransfer.findByTotalItems", query = "SELECT b FROM BranchTransfer b WHERE b.totalItems = :totalItems"),
    @NamedQuery(name = "BranchTransfer.findByDatetime", query = "SELECT b FROM BranchTransfer b WHERE b.datetime = :datetime")})
public class BranchTransfer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "total_items")
    private Integer totalItems;
    @Column(name = "datetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datetime;
    @JoinColumn(name = "accepted_branch", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Branch acceptedBranch;
    @JoinColumn(name = "transfered_branch", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Branch transferedBranch;
    @JoinColumn(name = "user", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Users user;

    public BranchTransfer() {
    }

    public BranchTransfer(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(Integer totalItems) {
        this.totalItems = totalItems;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public Branch getAcceptedBranch() {
        return acceptedBranch;
    }

    public void setAcceptedBranch(Branch acceptedBranch) {
        this.acceptedBranch = acceptedBranch;
    }

    public Branch getTransferedBranch() {
        return transferedBranch;
    }

    public void setTransferedBranch(Branch transferedBranch) {
        this.transferedBranch = transferedBranch;
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
        if (!(object instanceof BranchTransfer)) {
            return false;
        }
        BranchTransfer other = (BranchTransfer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cs.dao.BranchTransfer[ id=" + id + " ]";
    }
    
}
