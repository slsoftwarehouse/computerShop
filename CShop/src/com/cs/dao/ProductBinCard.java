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
@Table(name = "product_bin_card")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductBinCard.findAll", query = "SELECT p FROM ProductBinCard p"),
    @NamedQuery(name = "ProductBinCard.findById", query = "SELECT p FROM ProductBinCard p WHERE p.id = :id"),
    @NamedQuery(name = "ProductBinCard.findByDescription", query = "SELECT p FROM ProductBinCard p WHERE p.description = :description"),
    @NamedQuery(name = "ProductBinCard.findByIn", query = "SELECT p FROM ProductBinCard p WHERE p.in = :in"),
    @NamedQuery(name = "ProductBinCard.findByOut", query = "SELECT p FROM ProductBinCard p WHERE p.out = :out"),
    @NamedQuery(name = "ProductBinCard.findByDatetime", query = "SELECT p FROM ProductBinCard p WHERE p.datetime = :datetime"),
    @NamedQuery(name = "ProductBinCard.findByPrefix", query = "SELECT p FROM ProductBinCard p WHERE p.prefix = :prefix")})
public class ProductBinCard implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private String id;
    @Column(name = "description")
    private String description;
    @Column(name = "in")
    private Integer in;
    @Column(name = "out")
    private Integer out;
    @Column(name = "datetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datetime;
    @Column(name = "prefix")
    private String prefix;
    @JoinColumn(name = "org_branch", referencedColumnName = "id")
    @ManyToOne
    private Branch orgBranch;
    @JoinColumn(name = "product", referencedColumnName = "id")
    @ManyToOne
    private Product product;
    @JoinColumn(name = "serial", referencedColumnName = "serial")
    @ManyToOne
    private GrnLines serial;
    @JoinColumn(name = "user", referencedColumnName = "id")
    @ManyToOne
    private Users user;

    public ProductBinCard() {
    }

    public ProductBinCard(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getIn() {
        return in;
    }

    public void setIn(Integer in) {
        this.in = in;
    }

    public Integer getOut() {
        return out;
    }

    public void setOut(Integer out) {
        this.out = out;
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
        if (!(object instanceof ProductBinCard)) {
            return false;
        }
        ProductBinCard other = (ProductBinCard) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cs.dao.ProductBinCard[ id=" + id + " ]";
    }
    
}
