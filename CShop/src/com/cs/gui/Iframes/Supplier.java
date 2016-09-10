/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cs.gui.Iframes;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author hasangi
 */
@Entity
@Table(name = "supplier", catalog = "whole_sale", schema = "")
@NamedQueries({
    @NamedQuery(name = "Supplier.findAll", query = "SELECT s FROM Supplier s"),
    @NamedQuery(name = "Supplier.findBySupplierId", query = "SELECT s FROM Supplier s WHERE s.supplierId = :supplierId"),
    @NamedQuery(name = "Supplier.findBySupplierName", query = "SELECT s FROM Supplier s WHERE s.supplierName = :supplierName"),
    @NamedQuery(name = "Supplier.findBySupplierAddress", query = "SELECT s FROM Supplier s WHERE s.supplierAddress = :supplierAddress"),
    @NamedQuery(name = "Supplier.findBySupplierMobile", query = "SELECT s FROM Supplier s WHERE s.supplierMobile = :supplierMobile"),
    @NamedQuery(name = "Supplier.findBySupplierPhone1", query = "SELECT s FROM Supplier s WHERE s.supplierPhone1 = :supplierPhone1"),
    @NamedQuery(name = "Supplier.findBySupplierEmail", query = "SELECT s FROM Supplier s WHERE s.supplierEmail = :supplierEmail"),
    @NamedQuery(name = "Supplier.findBySupplierAccountId", query = "SELECT s FROM Supplier s WHERE s.supplierAccountId = :supplierAccountId")})
public class Supplier implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "supplier_id")
    private Integer supplierId;
    @Column(name = "supplier_name")
    private String supplierName;
    @Column(name = "supplier_address")
    private String supplierAddress;
    @Column(name = "supplier_mobile")
    private String supplierMobile;
    @Column(name = "supplier_phone1")
    private String supplierPhone1;
    @Column(name = "supplier_email")
    private String supplierEmail;
    @Column(name = "supplier_account_id")
    private Integer supplierAccountId;

    public Supplier() {
    }

    public Supplier(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        Integer oldSupplierId = this.supplierId;
        this.supplierId = supplierId;
        changeSupport.firePropertyChange("supplierId", oldSupplierId, supplierId);
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        String oldSupplierName = this.supplierName;
        this.supplierName = supplierName;
        changeSupport.firePropertyChange("supplierName", oldSupplierName, supplierName);
    }

    public String getSupplierAddress() {
        return supplierAddress;
    }

    public void setSupplierAddress(String supplierAddress) {
        String oldSupplierAddress = this.supplierAddress;
        this.supplierAddress = supplierAddress;
        changeSupport.firePropertyChange("supplierAddress", oldSupplierAddress, supplierAddress);
    }

    public String getSupplierMobile() {
        return supplierMobile;
    }

    public void setSupplierMobile(String supplierMobile) {
        String oldSupplierMobile = this.supplierMobile;
        this.supplierMobile = supplierMobile;
        changeSupport.firePropertyChange("supplierMobile", oldSupplierMobile, supplierMobile);
    }

    public String getSupplierPhone1() {
        return supplierPhone1;
    }

    public void setSupplierPhone1(String supplierPhone1) {
        String oldSupplierPhone1 = this.supplierPhone1;
        this.supplierPhone1 = supplierPhone1;
        changeSupport.firePropertyChange("supplierPhone1", oldSupplierPhone1, supplierPhone1);
    }

    public String getSupplierEmail() {
        return supplierEmail;
    }

    public void setSupplierEmail(String supplierEmail) {
        String oldSupplierEmail = this.supplierEmail;
        this.supplierEmail = supplierEmail;
        changeSupport.firePropertyChange("supplierEmail", oldSupplierEmail, supplierEmail);
    }

    public Integer getSupplierAccountId() {
        return supplierAccountId;
    }

    public void setSupplierAccountId(Integer supplierAccountId) {
        Integer oldSupplierAccountId = this.supplierAccountId;
        this.supplierAccountId = supplierAccountId;
        changeSupport.firePropertyChange("supplierAccountId", oldSupplierAccountId, supplierAccountId);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (supplierId != null ? supplierId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Supplier)) {
            return false;
        }
        Supplier other = (Supplier) object;
        if ((this.supplierId == null && other.supplierId != null) || (this.supplierId != null && !this.supplierId.equals(other.supplierId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cs.gui.Iframes.Supplier[ supplierId=" + supplierId + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
