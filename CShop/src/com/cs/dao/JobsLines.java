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
@Table(name = "jobs_lines")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "JobsLines.findAll", query = "SELECT j FROM JobsLines j"),
    @NamedQuery(name = "JobsLines.findById", query = "SELECT j FROM JobsLines j WHERE j.id = :id"),
    @NamedQuery(name = "JobsLines.findByOurItem", query = "SELECT j FROM JobsLines j WHERE j.ourItem = :ourItem"),
    @NamedQuery(name = "JobsLines.findByItemBill", query = "SELECT j FROM JobsLines j WHERE j.itemBill = :itemBill"),
    @NamedQuery(name = "JobsLines.findByIswarranty", query = "SELECT j FROM JobsLines j WHERE j.iswarranty = :iswarranty"),
    @NamedQuery(name = "JobsLines.findByIsNew", query = "SELECT j FROM JobsLines j WHERE j.isNew = :isNew"),
    @NamedQuery(name = "JobsLines.findByDatetime", query = "SELECT j FROM JobsLines j WHERE j.datetime = :datetime"),
    @NamedQuery(name = "JobsLines.findByPrefix", query = "SELECT j FROM JobsLines j WHERE j.prefix = :prefix")})
public class JobsLines implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private String id;
    @Column(name = "our_item")
    private Boolean ourItem;
    @Column(name = "item_bill")
    private Integer itemBill;
    @Column(name = "iswarranty")
    private Boolean iswarranty;
    @Column(name = "isNew")
    private Boolean isNew;
    @Column(name = "datetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datetime;
    @Column(name = "prefix")
    private String prefix;
    @JoinColumn(name = "job", referencedColumnName = "id")
    @ManyToOne
    private Jobs job;
    @JoinColumn(name = "product", referencedColumnName = "id")
    @ManyToOne
    private Product product;
    @JoinColumn(name = "serial", referencedColumnName = "serial")
    @ManyToOne
    private GrnLines serial;
    @JoinColumn(name = "user", referencedColumnName = "id")
    @ManyToOne
    private Users user;

    public JobsLines() {
    }

    public JobsLines(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getOurItem() {
        return ourItem;
    }

    public void setOurItem(Boolean ourItem) {
        this.ourItem = ourItem;
    }

    public Integer getItemBill() {
        return itemBill;
    }

    public void setItemBill(Integer itemBill) {
        this.itemBill = itemBill;
    }

    public Boolean getIswarranty() {
        return iswarranty;
    }

    public void setIswarranty(Boolean iswarranty) {
        this.iswarranty = iswarranty;
    }

    public Boolean getIsNew() {
        return isNew;
    }

    public void setIsNew(Boolean isNew) {
        this.isNew = isNew;
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

    public Jobs getJob() {
        return job;
    }

    public void setJob(Jobs job) {
        this.job = job;
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
        if (!(object instanceof JobsLines)) {
            return false;
        }
        JobsLines other = (JobsLines) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cs.dao.JobsLines[ id=" + id + " ]";
    }
    
}
