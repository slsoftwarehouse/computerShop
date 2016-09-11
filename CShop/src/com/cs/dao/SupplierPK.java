/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cs.dao;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author hasangi
 */
@Embeddable
public class SupplierPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "supplier_id")
    private int supplierId;
    @Basic(optional = false)
    @Column(name = "branch_id")
    private int branchId;

    public SupplierPK() {
        this.supplierId = new Long(System.currentTimeMillis()).intValue();
        this.branchId = 1;
    }

    public SupplierPK(int supplierId, int branchId) {
        this.supplierId = supplierId;
        this.branchId = branchId;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) supplierId;
        hash += (int) branchId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SupplierPK)) {
            return false;
        }
        SupplierPK other = (SupplierPK) object;
        if (this.supplierId != other.supplierId) {
            return false;
        }
        if (this.branchId != other.branchId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cs.dao.SupplierPK[ supplierId=" + supplierId + ", branchId=" + branchId + " ]";
    }
    
}
