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
@Table(name = "warrranty")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Warrranty.findAll", query = "SELECT w FROM Warrranty w"),
    @NamedQuery(name = "Warrranty.findById", query = "SELECT w FROM Warrranty w WHERE w.id = :id"),
    @NamedQuery(name = "Warrranty.findByBackupStatus", query = "SELECT w FROM Warrranty w WHERE w.backupStatus = :backupStatus"),
    @NamedQuery(name = "Warrranty.findByReceivedDate", query = "SELECT w FROM Warrranty w WHERE w.receivedDate = :receivedDate"),
    @NamedQuery(name = "Warrranty.findByWarrantyEndDate", query = "SELECT w FROM Warrranty w WHERE w.warrantyEndDate = :warrantyEndDate"),
    @NamedQuery(name = "Warrranty.findByWarrantyStatus", query = "SELECT w FROM Warrranty w WHERE w.warrantyStatus = :warrantyStatus"),
    @NamedQuery(name = "Warrranty.findBySentToSupplierDate", query = "SELECT w FROM Warrranty w WHERE w.sentToSupplierDate = :sentToSupplierDate"),
    @NamedQuery(name = "Warrranty.findByReceivedFromSupplierDate", query = "SELECT w FROM Warrranty w WHERE w.receivedFromSupplierDate = :receivedFromSupplierDate"),
    @NamedQuery(name = "Warrranty.findBySentToCustomerDate", query = "SELECT w FROM Warrranty w WHERE w.sentToCustomerDate = :sentToCustomerDate"),
    @NamedQuery(name = "Warrranty.findByDatetime", query = "SELECT w FROM Warrranty w WHERE w.datetime = :datetime"),
    @NamedQuery(name = "Warrranty.findByPrefix", query = "SELECT w FROM Warrranty w WHERE w.prefix = :prefix")})
public class Warrranty implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private String id;
    @Column(name = "backup_status")
    private Integer backupStatus;
    @Column(name = "received_date")
    @Temporal(TemporalType.DATE)
    private Date receivedDate;
    @Column(name = "warranty_end_date")
    @Temporal(TemporalType.DATE)
    private Date warrantyEndDate;
    @Column(name = "warranty_status")
    private Integer warrantyStatus;
    @Column(name = "sent_to_supplier_date")
    @Temporal(TemporalType.DATE)
    private Date sentToSupplierDate;
    @Column(name = "received_from_supplier_date")
    @Temporal(TemporalType.DATE)
    private Date receivedFromSupplierDate;
    @Column(name = "sent_to_customer_date")
    @Temporal(TemporalType.DATE)
    private Date sentToCustomerDate;
    @Column(name = "datetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datetime;
    @Column(name = "prefix")
    private String prefix;
    @JoinColumn(name = "backup_serial", referencedColumnName = "serial")
    @ManyToOne(fetch = FetchType.LAZY)
    private GrnLines backupSerial;
    @JoinColumn(name = "org_branch", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Branch orgBranch;
    @JoinColumn(name = "product", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;
    @JoinColumn(name = "serial", referencedColumnName = "serial")
    @ManyToOne(fetch = FetchType.LAZY)
    private GrnLines serial;
    @JoinColumn(name = "user", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Users user;

    public Warrranty() {
    }

    public Warrranty(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getBackupStatus() {
        return backupStatus;
    }

    public void setBackupStatus(Integer backupStatus) {
        this.backupStatus = backupStatus;
    }

    public Date getReceivedDate() {
        return receivedDate;
    }

    public void setReceivedDate(Date receivedDate) {
        this.receivedDate = receivedDate;
    }

    public Date getWarrantyEndDate() {
        return warrantyEndDate;
    }

    public void setWarrantyEndDate(Date warrantyEndDate) {
        this.warrantyEndDate = warrantyEndDate;
    }

    public Integer getWarrantyStatus() {
        return warrantyStatus;
    }

    public void setWarrantyStatus(Integer warrantyStatus) {
        this.warrantyStatus = warrantyStatus;
    }

    public Date getSentToSupplierDate() {
        return sentToSupplierDate;
    }

    public void setSentToSupplierDate(Date sentToSupplierDate) {
        this.sentToSupplierDate = sentToSupplierDate;
    }

    public Date getReceivedFromSupplierDate() {
        return receivedFromSupplierDate;
    }

    public void setReceivedFromSupplierDate(Date receivedFromSupplierDate) {
        this.receivedFromSupplierDate = receivedFromSupplierDate;
    }

    public Date getSentToCustomerDate() {
        return sentToCustomerDate;
    }

    public void setSentToCustomerDate(Date sentToCustomerDate) {
        this.sentToCustomerDate = sentToCustomerDate;
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

    public GrnLines getBackupSerial() {
        return backupSerial;
    }

    public void setBackupSerial(GrnLines backupSerial) {
        this.backupSerial = backupSerial;
    }

    public Branch getOrgBranch() {
        return orgBranch;
    }

    public void setOrgBranch(Branch orgBranch) {
        this.orgBranch = orgBranch;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public GrnLines getSerial() {
        return serial;
    }

    public void setSerial(GrnLines serial) {
        this.serial = serial;
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
        if (!(object instanceof Warrranty)) {
            return false;
        }
        Warrranty other = (Warrranty) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cs.dao.Warrranty[ id=" + id + " ]";
    }
    
}
