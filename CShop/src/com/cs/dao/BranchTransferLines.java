/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cs.dao;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
    @NamedQuery(name = "BranchTransferLines.findById", query = "SELECT b FROM BranchTransferLines b WHERE b.branchTransferLinesPK.id = :id"),
    @NamedQuery(name = "BranchTransferLines.findBySerial", query = "SELECT b FROM BranchTransferLines b WHERE b.branchTransferLinesPK.serial = :serial"),
    @NamedQuery(name = "BranchTransferLines.findByPcode", query = "SELECT b FROM BranchTransferLines b WHERE b.branchTransferLinesPK.pcode = :pcode"),
    @NamedQuery(name = "BranchTransferLines.findByQty", query = "SELECT b FROM BranchTransferLines b WHERE b.qty = :qty"),
    @NamedQuery(name = "BranchTransferLines.findByDatetime", query = "SELECT b FROM BranchTransferLines b WHERE b.datetime = :datetime"),
    @NamedQuery(name = "BranchTransferLines.findByPrefix", query = "SELECT b FROM BranchTransferLines b WHERE b.prefix = :prefix")})
public class BranchTransferLines implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BranchTransferLinesPK branchTransferLinesPK;
    @Column(name = "qty")
    private Integer qty;
    @Column(name = "datetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datetime;
    @Column(name = "prefix")
    private String prefix;
    @JoinColumn(name = "pcode", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Product product;
    @JoinColumn(name = "serial", referencedColumnName = "serial", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private GrnLines grnLines;
    @JoinColumn(name = "transfered_user", referencedColumnName = "id")
    @ManyToOne
    private Users transferedUser;
    @JoinColumn(name = "accepted_user", referencedColumnName = "id")
    @ManyToOne
    private Users acceptedUser;

    public BranchTransferLines() {
    }

    public BranchTransferLines(BranchTransferLinesPK branchTransferLinesPK) {
        this.branchTransferLinesPK = branchTransferLinesPK;
    }

    public BranchTransferLines(String id, String serial, String pcode) {
        this.branchTransferLinesPK = new BranchTransferLinesPK(id, serial, pcode);
    }

    public BranchTransferLinesPK getBranchTransferLinesPK() {
        return branchTransferLinesPK;
    }

    public void setBranchTransferLinesPK(BranchTransferLinesPK branchTransferLinesPK) {
        this.branchTransferLinesPK = branchTransferLinesPK;
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

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public GrnLines getGrnLines() {
        return grnLines;
    }

    public void setGrnLines(GrnLines grnLines) {
        this.grnLines = grnLines;
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
        hash += (branchTransferLinesPK != null ? branchTransferLinesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BranchTransferLines)) {
            return false;
        }
        BranchTransferLines other = (BranchTransferLines) object;
        if ((this.branchTransferLinesPK == null && other.branchTransferLinesPK != null) || (this.branchTransferLinesPK != null && !this.branchTransferLinesPK.equals(other.branchTransferLinesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cs.dao.BranchTransferLines[ branchTransferLinesPK=" + branchTransferLinesPK + " ]";
    }
    
}
