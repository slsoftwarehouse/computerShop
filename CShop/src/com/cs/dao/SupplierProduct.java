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
@Table(name = "supplier_product")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SupplierProduct.findAll", query = "SELECT s FROM SupplierProduct s"),
    @NamedQuery(name = "SupplierProduct.findBySupplier", query = "SELECT s FROM SupplierProduct s WHERE s.supplierProductPK.supplier = :supplier"),
    @NamedQuery(name = "SupplierProduct.findByProduct", query = "SELECT s FROM SupplierProduct s WHERE s.supplierProductPK.product = :product"),
    @NamedQuery(name = "SupplierProduct.findByDatetime", query = "SELECT s FROM SupplierProduct s WHERE s.datetime = :datetime"),
    @NamedQuery(name = "SupplierProduct.findByPrefix", query = "SELECT s FROM SupplierProduct s WHERE s.prefix = :prefix")})
public class SupplierProduct implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SupplierProductPK supplierProductPK;
    @Column(name = "datetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datetime;
    @Column(name = "prefix")
    private String prefix;
    @JoinColumn(name = "org_branch", referencedColumnName = "id")
    @ManyToOne
    private Branch orgBranch;
    @JoinColumn(name = "product", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Product product1;
    @JoinColumn(name = "supplier", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private com.cs.dao.Entity entity;
    @JoinColumn(name = "user", referencedColumnName = "id")
    @ManyToOne
    private Users user;

    public SupplierProduct() {
    }

    public SupplierProduct(SupplierProductPK supplierProductPK) {
        this.supplierProductPK = supplierProductPK;
    }

    public SupplierProduct(String supplier, String product) {
        this.supplierProductPK = new SupplierProductPK(supplier, product);
    }

    public SupplierProductPK getSupplierProductPK() {
        return supplierProductPK;
    }

    public void setSupplierProductPK(SupplierProductPK supplierProductPK) {
        this.supplierProductPK = supplierProductPK;
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

    public Branch getOrgBranch() {
        return orgBranch;
    }

    public void setOrgBranch(Branch orgBranch) {
        this.orgBranch = orgBranch;
    }

    public Product getProduct1() {
        return product1;
    }

    public void setProduct1(Product product1) {
        this.product1 = product1;
    }

    public com.cs.dao.Entity getEntity() {
        return entity;
    }

    public void setEntity(com.cs.dao.Entity entity) {
        this.entity = entity;
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
        hash += (supplierProductPK != null ? supplierProductPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SupplierProduct)) {
            return false;
        }
        SupplierProduct other = (SupplierProduct) object;
        if ((this.supplierProductPK == null && other.supplierProductPK != null) || (this.supplierProductPK != null && !this.supplierProductPK.equals(other.supplierProductPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cs.dao.SupplierProduct[ supplierProductPK=" + supplierProductPK + " ]";
    }
    
}
