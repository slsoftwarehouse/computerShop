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
@Table(name = "grn_return_lines")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GrnReturnLines.findAll", query = "SELECT g FROM GrnReturnLines g"),
    @NamedQuery(name = "GrnReturnLines.findById", query = "SELECT g FROM GrnReturnLines g WHERE g.id = :id"),
    @NamedQuery(name = "GrnReturnLines.findByQty", query = "SELECT g FROM GrnReturnLines g WHERE g.qty = :qty"),
    @NamedQuery(name = "GrnReturnLines.findByCostPrice", query = "SELECT g FROM GrnReturnLines g WHERE g.costPrice = :costPrice"),
    @NamedQuery(name = "GrnReturnLines.findByDatetime", query = "SELECT g FROM GrnReturnLines g WHERE g.datetime = :datetime"),
    @NamedQuery(name = "GrnReturnLines.findByPrefix", query = "SELECT g FROM GrnReturnLines g WHERE g.prefix = :prefix")})
public class GrnReturnLines implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private String id;
    @Column(name = "qty")
    private Integer qty;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cost_price")
    private Double costPrice;
    @Column(name = "datetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datetime;
    @Column(name = "prefix")
    private String prefix;
    @JoinColumn(name = "product", referencedColumnName = "id")
    @ManyToOne
    private Product product;
    @JoinColumn(name = "return", referencedColumnName = "id")
    @ManyToOne
    private GrnReturn return1;
    @JoinColumn(name = "serial", referencedColumnName = "serial")
    @ManyToOne
    private GrnLines serial;
    @JoinColumn(name = "user", referencedColumnName = "id")
    @ManyToOne
    private Users user;

    public GrnReturnLines() {
    }

    public GrnReturnLines(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Double getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(Double costPrice) {
        this.costPrice = costPrice;
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

    public GrnReturn getReturn1() {
        return return1;
    }

    public void setReturn1(GrnReturn return1) {
        this.return1 = return1;
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
        if (!(object instanceof GrnReturnLines)) {
            return false;
        }
        GrnReturnLines other = (GrnReturnLines) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cs.dao.GrnReturnLines[ id=" + id + " ]";
    }
    
}
