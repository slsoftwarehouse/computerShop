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
@Table(name = "branch_transfer_lines")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BranchTransferLines.findAll", query = "SELECT b FROM BranchTransferLines b"),
    @NamedQuery(name = "BranchTransferLines.findById", query = "SELECT b FROM BranchTransferLines b WHERE b.id = :id"),
    @NamedQuery(name = "BranchTransferLines.findByQty", query = "SELECT b FROM BranchTransferLines b WHERE b.qty = :qty"),
    @NamedQuery(name = "BranchTransferLines.findByDatetime", query = "SELECT b FROM BranchTransferLines b WHERE b.datetime = :datetime")})
public class BranchTransferLines implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "qty")
    private Integer qty;
    @Column(name = "datetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datetime;
    @JoinColumn(name = "pcode", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Product pcode;
    @JoinColumn(name = "serial", referencedColumnName = "serial")
    @ManyToOne(fetch = FetchType.LAZY)
    private GrnLines serial;
    @JoinColumn(name = "transfered_user", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Users transferedUser;
    @JoinColumn(name = "accepted_user", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Users acceptedUser;

    public BranchTransferLines() {
    }

    public BranchTransferLines(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public Product getPcode() {
        return pcode;
    }

    public void setPcode(Product pcode) {
        this.pcode = pcode;
    }

    public GrnLines getSerial() {
        return serial;
    }

    public void setSerial(GrnLines serial) {
        this.serial = serial;
    }

    public Users getTransferedUser() {
        return transferedUser;
    }

    public void setTransferedUser(Users transferedUser) {
        this.transferedUser = transferedUser;
    }

    public Users getAcceptedUser() {
        return acceptedUser;
    }

    public void setAcceptedUser(Users acceptedUser) {
        this.acceptedUser = acceptedUser;
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
        if (!(object instanceof BranchTransferLines)) {
            return false;
        }
        BranchTransferLines other = (BranchTransferLines) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cs.dao.BranchTransferLines[ id=" + id + " ]";
    }
    
}
