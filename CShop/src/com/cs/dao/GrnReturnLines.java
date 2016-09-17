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
@Table(name = "grn_return_lines")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GrnReturnLines.findAll", query = "SELECT g FROM GrnReturnLines g"),
    @NamedQuery(name = "GrnReturnLines.findById", query = "SELECT g FROM GrnReturnLines g WHERE g.grnReturnLinesPK.id = :id"),
    @NamedQuery(name = "GrnReturnLines.findByReturn1", query = "SELECT g FROM GrnReturnLines g WHERE g.grnReturnLinesPK.return1 = :return1"),
    @NamedQuery(name = "GrnReturnLines.findByProduct", query = "SELECT g FROM GrnReturnLines g WHERE g.grnReturnLinesPK.product = :product"),
    @NamedQuery(name = "GrnReturnLines.findBySerial", query = "SELECT g FROM GrnReturnLines g WHERE g.grnReturnLinesPK.serial = :serial"),
    @NamedQuery(name = "GrnReturnLines.findByQty", query = "SELECT g FROM GrnReturnLines g WHERE g.qty = :qty"),
    @NamedQuery(name = "GrnReturnLines.findByCostPrice", query = "SELECT g FROM GrnReturnLines g WHERE g.costPrice = :costPrice"),
    @NamedQuery(name = "GrnReturnLines.findByDatetime", query = "SELECT g FROM GrnReturnLines g WHERE g.datetime = :datetime"),
    @NamedQuery(name = "GrnReturnLines.findByPrefix", query = "SELECT g FROM GrnReturnLines g WHERE g.prefix = :prefix")})
public class GrnReturnLines implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected GrnReturnLinesPK grnReturnLinesPK;
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
    @JoinColumn(name = "product", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Product product1;
    @JoinColumn(name = "return", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private GrnReturn grnReturn;
    @JoinColumn(name = "serial", referencedColumnName = "serial", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private GrnLines grnLines;
    @JoinColumn(name = "user", referencedColumnName = "id")
    @ManyToOne
    private Users user;

    public GrnReturnLines() {
    }

    public GrnReturnLines(GrnReturnLinesPK grnReturnLinesPK) {
        this.grnReturnLinesPK = grnReturnLinesPK;
    }

    public GrnReturnLines(String id, String return1, String product, String serial) {
        this.grnReturnLinesPK = new GrnReturnLinesPK(id, return1, product, serial);
    }

    public GrnReturnLinesPK getGrnReturnLinesPK() {
        return grnReturnLinesPK;
    }

    public void setGrnReturnLinesPK(GrnReturnLinesPK grnReturnLinesPK) {
        this.grnReturnLinesPK = grnReturnLinesPK;
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

    public Product getProduct1() {
        return product1;
    }

    public void setProduct1(Product product1) {
        this.product1 = product1;
    }

    public GrnReturn getGrnReturn() {
        return grnReturn;
    }

    public void setGrnReturn(GrnReturn grnReturn) {
        this.grnReturn = grnReturn;
    }

    public GrnLines getGrnLines() {
        return grnLines;
    }

    public void setGrnLines(GrnLines grnLines) {
        this.grnLines = grnLines;
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
        hash += (grnReturnLinesPK != null ? grnReturnLinesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GrnReturnLines)) {
            return false;
        }
        GrnReturnLines other = (GrnReturnLines) object;
        if ((this.grnReturnLinesPK == null && other.grnReturnLinesPK != null) || (this.grnReturnLinesPK != null && !this.grnReturnLinesPK.equals(other.grnReturnLinesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cs.dao.GrnReturnLines[ grnReturnLinesPK=" + grnReturnLinesPK + " ]";
    }
    
}
