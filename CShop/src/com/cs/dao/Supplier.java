/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cs.dao;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author hasangi
 */
@Entity
@Table(name = "supplier")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Supplier.findAll", query = "SELECT s FROM Supplier s"),
    @NamedQuery(name = "Supplier.findBySupplierId", query = "SELECT s FROM Supplier s WHERE s.supplierPK.supplierId = :supplierId"),
    @NamedQuery(name = "Supplier.findBySupplierName", query = "SELECT s FROM Supplier s WHERE s.supplierName = :supplierName"),
    @NamedQuery(name = "Supplier.findBySupplierAddress", query = "SELECT s FROM Supplier s WHERE s.supplierAddress = :supplierAddress"),
    @NamedQuery(name = "Supplier.findBySupplierMobile", query = "SELECT s FROM Supplier s WHERE s.supplierMobile = :supplierMobile"),
    @NamedQuery(name = "Supplier.findBySupplierPhone1", query = "SELECT s FROM Supplier s WHERE s.supplierPhone1 = :supplierPhone1"),
    @NamedQuery(name = "Supplier.findBySupplierEmail", query = "SELECT s FROM Supplier s WHERE s.supplierEmail = :supplierEmail"),
    @NamedQuery(name = "Supplier.findByBranchId", query = "SELECT s FROM Supplier s WHERE s.supplierPK.branchId = :branchId"),
    @NamedQuery(name = "Supplier.findByUpdatedToServer", query = "SELECT s FROM Supplier s WHERE s.updatedToServer = :updatedToServer")})
public class Supplier implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SupplierPK supplierPK;
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
    @Column(name = "updated_to_server")
    private Integer updatedToServer;

    public Supplier() {
    }

    public Supplier(SupplierPK supplierPK) {
        this.supplierPK = supplierPK;
    }

    public Supplier(int supplierId, int branchId) {
        this.supplierPK = new SupplierPK(supplierId, branchId);
    }

    public SupplierPK getSupplierPK() {
        return supplierPK;
    }

    public void setSupplierPK(SupplierPK supplierPK) {
        this.supplierPK = supplierPK;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierAddress() {
        return supplierAddress;
    }

    public void setSupplierAddress(String supplierAddress) {
        this.supplierAddress = supplierAddress;
    }

    public String getSupplierMobile() {
        return supplierMobile;
    }

    public void setSupplierMobile(String supplierMobile) {
        this.supplierMobile = supplierMobile;
    }

    public String getSupplierPhone1() {
        return supplierPhone1;
    }

    public void setSupplierPhone1(String supplierPhone1) {
        this.supplierPhone1 = supplierPhone1;
    }

    public String getSupplierEmail() {
        return supplierEmail;
    }

    public void setSupplierEmail(String supplierEmail) {
        this.supplierEmail = supplierEmail;
    }

    public Integer getUpdatedToServer() {
        return updatedToServer;
    }

    public void setUpdatedToServer(Integer updatedToServer) {
        this.updatedToServer = updatedToServer;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (supplierPK != null ? supplierPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Supplier)) {
            return false;
        }
        Supplier other = (Supplier) object;
        if ((this.supplierPK == null && other.supplierPK != null) || (this.supplierPK != null && !this.supplierPK.equals(other.supplierPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cs.dao.Supplier[ supplierPK=" + supplierPK + " ]";
    }
    
}
