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
 * @author home
 */
@Embeddable
public class SupplierProductPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "supplier")
    private String supplier;
    @Basic(optional = false)
    @Column(name = "product")
    private String product;

    public SupplierProductPK() {
    }

    public SupplierProductPK(String supplier, String product) {
        this.supplier = supplier;
        this.product = product;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (supplier != null ? supplier.hashCode() : 0);
        hash += (product != null ? product.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SupplierProductPK)) {
            return false;
        }
        SupplierProductPK other = (SupplierProductPK) object;
        if ((this.supplier == null && other.supplier != null) || (this.supplier != null && !this.supplier.equals(other.supplier))) {
            return false;
        }
        if ((this.product == null && other.product != null) || (this.product != null && !this.product.equals(other.product))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cs.dao.SupplierProductPK[ supplier=" + supplier + ", product=" + product + " ]";
    }
    
}
