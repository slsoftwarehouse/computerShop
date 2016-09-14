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
public class ProductPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "product_id")
    private int productId;
    @Basic(optional = false)
    @Column(name = "branch_id")
    private int branchId;

    public ProductPK() {
        this.productId = new Long(System.currentTimeMillis()).intValue();
        this.branchId = 1;
    }

    public ProductPK(int productId, int branchId) {
        this.productId = productId;
        this.branchId = branchId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
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
        hash += (int) productId;
        hash += (int) branchId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductPK)) {
            return false;
        }
        ProductPK other = (ProductPK) object;
        if (this.productId != other.productId) {
            return false;
        }
        if (this.branchId != other.branchId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cs.dao.ProductPK[ productId=" + productId + ", branchId=" + branchId + " ]";
    }
    
}
