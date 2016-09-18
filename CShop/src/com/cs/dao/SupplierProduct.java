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
@Table(name = "supplier_product")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SupplierProduct.findAll", query = "SELECT s FROM SupplierProduct s"),
    @NamedQuery(name = "SupplierProduct.findByDatetime", query = "SELECT s FROM SupplierProduct s WHERE s.datetime = :datetime"),
    @NamedQuery(name = "SupplierProduct.findByPrefix", query = "SELECT s FROM SupplierProduct s WHERE s.prefix = :prefix"),
    @NamedQuery(name = "SupplierProduct.findById", query = "SELECT s FROM SupplierProduct s WHERE s.id = :id")})
public class SupplierProduct implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "datetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datetime;
    @Column(name = "prefix")
    private String prefix;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private String id;
    @JoinColumn(name = "product", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Product product;
    @JoinColumn(name = "org_branch", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Branch orgBranch;
    @JoinColumn(name = "supplier", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private com.cs.dao.Entity supplier;
    @JoinColumn(name = "user", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Users user;

    public SupplierProduct() {
    }

    public SupplierProduct(String id) {
        this.id = id;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Branch getOrgBranch() {
        return orgBranch;
    }

    public void setOrgBranch(Branch orgBranch) {
        this.orgBranch = orgBranch;
    }

    public com.cs.dao.Entity getSupplier() {
        return supplier;
    }

    public void setSupplier(com.cs.dao.Entity supplier) {
        this.supplier = supplier;
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
        if (!(object instanceof SupplierProduct)) {
            return false;
        }
        SupplierProduct other = (SupplierProduct) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cs.dao.SupplierProduct[ id=" + id + " ]";
    }
    
}
